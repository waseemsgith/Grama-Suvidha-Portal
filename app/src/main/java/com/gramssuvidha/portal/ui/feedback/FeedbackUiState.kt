package com.gramssuvidha.portal.ui.feedback

import com.gramssuvidha.portal.domain.model.IssueType

/**
 * Immutable UI state for the Feedback screen.
 */
data class FeedbackUiState(
    val rating: Int = 0,
    val comment: String = "",
    val citizenName: String = "",
    val citizenContact: String = "",
    val selectedIssueType: IssueType = IssueType.GENERAL,
    val isSubmitting: Boolean = false,
    val isSubmitted: Boolean = false,
    val aiCategory: String = "",
    val isAiCategorizing: Boolean = false,
    val errorMessage: String? = null,
    // Validation errors
    val ratingError: String? = null,
    val commentError: String? = null,
    val nameError: String? = null
)
