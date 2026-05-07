package com.gramssuvidha.portal.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectStatus
import com.gramssuvidha.portal.domain.repository.AIRepository
import com.gramssuvidha.portal.domain.repository.ProjectRepository
import com.gramssuvidha.portal.domain.usecase.GetProjectsUseCase
import com.gramssuvidha.portal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Home screen.
 * Manages project list, search, filter, and AI insights.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProjectsUseCase: GetProjectsUseCase,
    private val projectRepository: ProjectRepository,
    private val aiRepository: AIRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // Internal search & filter trigger flows
    private val _searchQuery   = MutableStateFlow("")
    private val _statusFilter  = MutableStateFlow<ProjectStatus?>(null)
    // All projects fetched from DB (unfiltered)
    private val _allProjects   = MutableStateFlow<List<Project>>(emptyList())

    init {
        loadProjects()
        refreshFromNetwork()
        startInsightRotation()
        observeFilters()
    }

    /** Observe DB projects and store them; apply filters reactively */
    private fun loadProjects() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getProjectsUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Loading -> _uiState.update {
                        it.copy(isLoading = true, errorMessage = null)
                    }
                    is Resource.Success -> {
                        _allProjects.value = result.data
                        _uiState.update {
                            it.copy(isLoading = false, projects = result.data, errorMessage = null)
                        }
                        applyFilters()
                    }
                    is Resource.Error -> _uiState.update {
                        it.copy(isLoading = false, errorMessage = result.message)
                    }
                }
            }
        }
    }

    /** Reactively re-filter whenever query or status changes */
    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeFilters() {
        viewModelScope.launch {
            combine(_searchQuery, _statusFilter) { q, f -> Pair(q, f) }
                .collect { _ -> applyFilters() }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun onFilterSelected(status: ProjectStatus?) {
        _statusFilter.value = status
        _uiState.update { it.copy(selectedFilter = status) }
    }

    private fun applyFilters() {
        val query  = _searchQuery.value
        val filter = _statusFilter.value
        val filtered = _allProjects.value.filter { project ->
            val matchesQuery = query.isEmpty() ||
                    project.title.contains(query, ignoreCase = true) ||
                    project.description.contains(query, ignoreCase = true) ||
                    project.location.contains(query, ignoreCase = true)
            val matchesFilter = filter == null || project.status == filter
            matchesQuery && matchesFilter
        }
        _uiState.update { it.copy(filteredProjects = filtered) }
    }

    fun onRefresh() {
        _uiState.update { it.copy(isRefreshing = true) }
        viewModelScope.launch {
            val result = projectRepository.refreshProjects()
            _uiState.update {
                it.copy(
                    isRefreshing = false,
                    errorMessage = if (result is Resource.Error) result.message else null
                )
            }
        }
    }

    fun refreshFromNetwork() {
        viewModelScope.launch { projectRepository.refreshProjects() }
    }

    private fun startInsightRotation() {
        viewModelScope.launch {
            aiRepository.getVillageInsights().collect { insight ->
                _uiState.update { it.copy(villageInsight = insight) }
            }
        }
    }

    fun dismissError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}
