package com.gramssuvidha.portal.domain.repository

import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectUpdate
import com.gramssuvidha.portal.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for project data operations.
 * Follows the single source of truth principle.
 */
interface ProjectRepository {
    /** Observe all cached projects as a Flow */
    fun getProjects(): Flow<Resource<List<Project>>>

    /** Get a single project by ID */
    fun getProjectById(id: String): Flow<Resource<Project>>

    /** Get timeline updates for a project */
    fun getProjectUpdates(projectId: String): Flow<Resource<List<ProjectUpdate>>>

    /** Force-refresh projects from network */
    suspend fun refreshProjects(): Resource<Unit>
}
