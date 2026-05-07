package com.gramssuvidha.portal.domain.repository

import com.gramssuvidha.portal.domain.model.Feedback
import com.gramssuvidha.portal.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for citizen feedback operations.
 */
interface FeedbackRepository {
    /** Submit or queue feedback (offline-first) */
    suspend fun submitFeedback(feedback: Feedback): Resource<Unit>

    /** Get all feedback for a project */
    fun getFeedbackForProject(projectId: String): Flow<Resource<List<Feedback>>>

    /** Sync pending (offline) feedback to remote */
    suspend fun syncPendingFeedback(): Resource<Unit>
}
