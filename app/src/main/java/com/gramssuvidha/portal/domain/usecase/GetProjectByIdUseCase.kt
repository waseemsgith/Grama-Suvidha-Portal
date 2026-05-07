package com.gramssuvidha.portal.domain.usecase

import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.repository.ProjectRepository
import com.gramssuvidha.portal.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case that retrieves a single project by its ID.
 */
class GetProjectByIdUseCase @Inject constructor(
    private val repository: ProjectRepository
) {
    operator fun invoke(id: String): Flow<Resource<Project>> =
        repository.getProjectById(id)
}
