package com.gramssuvidha.portal.ui.home

import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectStatus

/**
 * Immutable UI state for the Home screen.
 */
data class HomeUiState(
    val isLoading: Boolean = false,
    val projects: List<Project> = emptyList(),
    val filteredProjects: List<Project> = emptyList(),
    val searchQuery: String = "",
    val selectedFilter: ProjectStatus? = null,
    val isRefreshing: Boolean = false,
    val errorMessage: String? = null,
    val villageInsight: String = "",
    val panchayatName: String = "Ketaganahalli Gram Panchayat"
)
