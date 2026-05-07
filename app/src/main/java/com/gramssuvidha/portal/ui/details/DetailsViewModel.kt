package com.gramssuvidha.portal.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gramssuvidha.portal.domain.repository.AIRepository
import com.gramssuvidha.portal.domain.repository.ProjectRepository
import com.gramssuvidha.portal.domain.usecase.GetProjectByIdUseCase
import com.gramssuvidha.portal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Project Details screen.
 * Loads project, updates, and AI summary.
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getProjectByIdUseCase: GetProjectByIdUseCase,
    private val projectRepository: ProjectRepository,
    private val aiRepository: AIRepository
) : ViewModel() {

    private val projectId: String = checkNotNull(savedStateHandle["projectId"])

    private val _uiState = MutableStateFlow(DetailsUiState())
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()

    init {
        loadProject()
        loadUpdates()
    }

    private fun loadProject() {
        viewModelScope.launch {
            getProjectByIdUseCase(projectId).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> _uiState.update { it.copy(isLoading = true) }
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                project = result.data,
                                errorMessage = null
                            )
                        }
                        // Trigger AI summary generation after project loads
                        generateAiSummary(
                            result.data.title,
                            result.data.progressPercent,
                            result.data.status.name
                        )
                    }
                    is Resource.Error -> _uiState.update {
                        it.copy(isLoading = false, errorMessage = result.message)
                    }
                }
            }
        }
    }

    private fun loadUpdates() {
        viewModelScope.launch {
            projectRepository.getProjectUpdates(projectId).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> _uiState.update { it.copy(isUpdatesLoading = true) }
                    is Resource.Success -> _uiState.update {
                        it.copy(isUpdatesLoading = false, updates = result.data)
                    }
                    is Resource.Error -> _uiState.update { it.copy(isUpdatesLoading = false) }
                }
            }
        }
    }

    private fun generateAiSummary(title: String, progress: Int, status: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isAiLoading = true) }
            try {
                val summary = aiRepository.generateProgressSummary(title, progress, status)
                _uiState.update { it.copy(isAiLoading = false, aiSummary = summary) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isAiLoading = false) }
            }
        }
    }
}
