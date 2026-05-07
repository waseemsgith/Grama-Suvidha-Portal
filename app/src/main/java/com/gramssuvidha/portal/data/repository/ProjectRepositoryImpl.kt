package com.gramssuvidha.portal.data.repository

import com.gramssuvidha.portal.data.local.dao.ProjectDao
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao
import com.gramssuvidha.portal.data.mapper.toDomain
import com.gramssuvidha.portal.data.mapper.toEntity
import com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService
import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectUpdate
import com.gramssuvidha.portal.domain.repository.ProjectRepository
import com.gramssuvidha.portal.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Concrete implementation of [ProjectRepository].
 * Uses Room as the single source of truth with network as a refresh source.
 */
@Singleton
class ProjectRepositoryImpl @Inject constructor(
    private val projectDao: ProjectDao,
    private val projectUpdateDao: ProjectUpdateDao,
    private val apiService: GramaSuvidhaApiService
) : ProjectRepository {

    override fun getProjects(): Flow<Resource<List<Project>>> {
        return projectDao.getAllProjects()
            .map<_, Resource<List<Project>>> { entities ->
                Resource.Success(entities.map { it.toDomain() })
            }
            .onStart { emit(Resource.Loading) }
            .catch { e -> emit(Resource.Error(e.message ?: "Database error")) }
    }

    override fun getProjectById(id: String): Flow<Resource<Project>> {
        return projectDao.getProjectById(id)
            .map<_, Resource<Project>> { entity ->
                if (entity != null) Resource.Success(entity.toDomain())
                else Resource.Error("Project not found")
            }
            .onStart { emit(Resource.Loading) }
            .catch { e -> emit(Resource.Error(e.message ?: "Database error")) }
    }

    override fun getProjectUpdates(projectId: String): Flow<Resource<List<ProjectUpdate>>> {
        return projectUpdateDao.getUpdatesForProject(projectId)
            .map<_, Resource<List<ProjectUpdate>>> { entities ->
                Resource.Success(entities.map { it.toDomain() })
            }
            .onStart { emit(Resource.Loading) }
            .catch { e -> emit(Resource.Error(e.message ?: "Database error")) }
    }

    override suspend fun refreshProjects(): Resource<Unit> {
        return try {
            val response = apiService.getProjects()
            if (response.success) {
                val entities = response.data.map { it.toEntity() }
                projectDao.insertProjects(entities)

                // Also refresh updates for each project
                response.data.forEach { project ->
                    try {
                        val updatesResponse = apiService.getProjectUpdates(project.id)
                        if (updatesResponse.success) {
                            val updateEntities = updatesResponse.data.map { it.toEntity() }
                            projectUpdateDao.insertUpdates(updateEntities)
                        }
                    } catch (_: Exception) { /* Non-critical; skip silently */ }
                }
                Resource.Success(Unit)
            } else {
                Resource.Error("Server returned failure")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Network error during refresh")
        }
    }
}
