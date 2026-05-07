package com.gramssuvidha.portal.ui.feedback

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gramssuvidha.portal.domain.model.Feedback
import com.gramssuvidha.portal.domain.model.IssueType
import com.gramssuvidha.portal.domain.repository.AIRepository
import com.gramssuvidha.portal.domain.usecase.SubmitFeedbackUseCase
import com.gramssuvidha.portal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * ViewModel for the Feedback screen.
 * Handles form state, validation, AI categorization, and submission.
 */
@HiltViewModel
class FeedbackViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val submitFeedbackUseCase: SubmitFeedbackUseCase,
    private val aiRepository: AIRepository
) : ViewModel() {

    val projectId: String = checkNotNull(savedStateHandle["projectId"])
    val projectTitle: String = checkNotNull(savedStateHandle["projectTitle"])

    private val _uiState = MutableStateFlow(FeedbackUiState())
    val uiState: StateFlow<FeedbackUiState> = _uiState.asStateFlow()

    private var aiJob: Job? = null

    fun onRatingChange(rating: Int) {
        _uiState.update { it.copy(rating = rating, ratingError = null) }
    }

    fun onCommentChange(comment: String) {
        _uiState.update { it.copy(comment = comment, commentError = null) }
        // Debounce AI categorization
        aiJob?.cancel()
        if (comment.length > 15) {
            aiJob = viewModelScope.launch {
                delay(800)
                categorizeComment(comment)
            }
        }
    }

    fun onNameChange(name: String) {
        _uiState.update { it.copy(citizenName = name, nameError = null) }
    }

    fun onContactChange(contact: String) {
        _uiState.update { it.copy(citizenContact = contact) }
    }

    fun onIssueTypeSelected(issueType: IssueType) {
        _uiState.update { it.copy(selectedIssueType = issueType) }
    }

    private suspend fun categorizeComment(text: String) {
        _uiState.update { it.copy(isAiCategorizing = true) }
        try {
            val category = aiRepository.categorizeIssue(text)
            _uiState.update { it.copy(aiCategory = category, isAiCategorizing = false) }
        } catch (e: Exception) {
            _uiState.update { it.copy(isAiCategorizing = false) }
        }
    }

    fun submitFeedback() {
        if (!validate()) return

        val state = _uiState.value
        viewModelScope.launch {
            _uiState.update { it.copy(isSubmitting = true, errorMessage = null) }
            val feedback = Feedback(
                id = UUID.randomUUID().toString(),
                projectId = projectId,
                projectTitle = projectTitle.replace("|", "/"),
                rating = state.rating,
                comment = state.comment,
                issueType = state.selectedIssueType,
                citizenName = state.citizenName,
                citizenContact = state.citizenContact,
                imageUrl = null,
                isSubmitted = false,
                submittedAt = System.currentTimeMillis(),
                aiCategory = state.aiCategory
            )
            val result = submitFeedbackUseCase(feedback)
            when (result) {
                is Resource.Success -> _uiState.update {
                    it.copy(isSubmitting = false, isSubmitted = true)
                }
                is Resource.Error -> _uiState.update {
                    it.copy(isSubmitting = false, errorMessage = result.message)
                }
                else -> _uiState.update { it.copy(isSubmitting = false) }
            }
        }
    }

    private fun validate(): Boolean {
        val state = _uiState.value
        var isValid = true
        if (state.rating == 0) {
            _uiState.update { it.copy(ratingError = "Please select a rating") }
            isValid = false
        }
        if (state.comment.isBlank() || state.comment.length < 10) {
            _uiState.update { it.copy(commentError = "Please write at least 10 characters") }
            isValid = false
        }
        if (state.citizenName.isBlank()) {
            _uiState.update { it.copy(nameError = "Please enter your name") }
            isValid = false
        }
        return isValid
    }
}
