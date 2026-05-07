package com.gramssuvidha.portal.data.repository

import com.gramssuvidha.portal.data.local.dao.FeedbackDao
import com.gramssuvidha.portal.data.mapper.toDomain
import com.gramssuvidha.portal.data.mapper.toDto
import com.gramssuvidha.portal.data.mapper.toEntity
import com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService
import com.gramssuvidha.portal.domain.model.Feedback
import com.gramssuvidha.portal.domain.repository.FeedbackRepository
import com.gramssuvidha.portal.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Offline-first feedback repository.
 * Saves feedback locally first, then syncs to remote when online.
 */
@Singleton
class FeedbackRepositoryImpl @Inject constructor(
    private val feedbackDao: FeedbackDao,
    private val apiService: GramaSuvidhaApiService
) : FeedbackRepository {

    override suspend fun submitFeedback(feedback: Feedback): Resource<Unit> {
        return try {
            // 1. Always save locally first (offline-first)
            feedbackDao.insertFeedback(feedback.toEntity())

            // 2. Attempt to sync to server
            try {
                val response = apiService.submitFeedback(feedback.toDto())
                if (response.success) {
                    feedbackDao.markAsSubmitted(feedback.id)
                }
            } catch (_: Exception) {
                // Network unavailable — feedback is queued locally
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Failed to save feedback")
        }
    }

    override fun getFeedbackForProject(projectId: String): Flow<Resource<List<Feedback>>> {
        return feedbackDao.getFeedbackForProject(projectId)
            .map<_, Resource<List<Feedback>>> { entities ->
                Resource.Success(entities.map { it.toDomain() })
            }
            .onStart { emit(Resource.Loading) }
            .catch { e -> emit(Resource.Error(e.message ?: "Database error")) }
    }

    override suspend fun syncPendingFeedback(): Resource<Unit> {
        return try {
            val pending = feedbackDao.getPendingFeedback()
            pending.forEach { entity ->
                try {
                    val response = apiService.submitFeedback(entity.toDomain().toDto())
                    if (response.success) {
                        feedbackDao.markAsSubmitted(entity.id)
                    }
                } catch (_: Exception) { /* Skip failed items; will retry later */ }
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Sync failed")
        }
    }
}
