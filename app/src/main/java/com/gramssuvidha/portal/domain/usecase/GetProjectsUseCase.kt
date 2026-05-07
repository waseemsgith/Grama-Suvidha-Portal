package com.gramssuvidha.portal.domain.usecase

import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectStatus
import com.gramssuvidha.portal.domain.repository.ProjectRepository
import com.gramssuvidha.portal.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Use case that retrieves and optionally filters projects by status/search query.
 */
class GetProjectsUseCase @Inject constructor(
    private val repository: ProjectRepository
) {
    operator fun invoke(
        query: String = "",
        statusFilter: ProjectStatus? = null
    ): Flow<Resource<List<Project>>> {
        return repository.getProjects().map { result ->
            when (result) {
                is Resource.Success -> {
                    val filtered = result.data
                        .filter { project ->
                            (query.isEmpty() ||
                                    project.title.contains(query, ignoreCase = true) ||
                                    project.description.contains(query, ignoreCase = true) ||
                                    project.location.contains(query, ignoreCase = true))
                                    &&
                                    (statusFilter == null || project.status == statusFilter)
                        }
                    Resource.Success(filtered)
                }
                is Resource.Error -> result
                is Resource.Loading -> result
            }
        }
    }
}
