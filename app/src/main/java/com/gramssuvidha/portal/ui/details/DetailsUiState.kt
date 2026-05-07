package com.gramssuvidha.portal.ui.details

import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectUpdate

/**
 * Immutable UI state for the Project Details screen.
 */
data class DetailsUiState(
    val isLoading: Boolean = false,
    val project: Project? = null,
    val updates: List<ProjectUpdate> = emptyList(),
    val isUpdatesLoading: Boolean = false,
    val aiSummary: String = "",
    val isAiLoading: Boolean = false,
    val errorMessage: String? = null
)
