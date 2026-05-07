package com.gramssuvidha.portal.ui.home;

/**
 * ViewModel for the Home screen.
 * Manages project list, search, filter, and AI insights.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001e\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u0018J\b\u0010\"\u001a\u00020\u0018H\u0002R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/gramssuvidha/portal/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "getProjectsUseCase", "Lcom/gramssuvidha/portal/domain/usecase/GetProjectsUseCase;", "projectRepository", "Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "aiRepository", "Lcom/gramssuvidha/portal/domain/repository/AIRepository;", "(Lcom/gramssuvidha/portal/domain/usecase/GetProjectsUseCase;Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;Lcom/gramssuvidha/portal/domain/repository/AIRepository;)V", "_allProjects", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/gramssuvidha/portal/domain/model/Project;", "_searchQuery", "", "_statusFilter", "Lcom/gramssuvidha/portal/domain/model/ProjectStatus;", "_uiState", "Lcom/gramssuvidha/portal/ui/home/HomeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "applyFilters", "", "dismissError", "loadProjects", "observeFilters", "onFilterSelected", "status", "onRefresh", "onSearchQueryChange", "query", "refreshFromNetwork", "startInsightRotation", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.usecase.GetProjectsUseCase getProjectsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.ProjectRepository projectRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.AIRepository aiRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gramssuvidha.portal.ui.home.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.gramssuvidha.portal.ui.home.HomeUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gramssuvidha.portal.domain.model.ProjectStatus> _statusFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.gramssuvidha.portal.domain.model.Project>> _allProjects = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.usecase.GetProjectsUseCase getProjectsUseCase, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.ProjectRepository projectRepository, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.AIRepository aiRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.gramssuvidha.portal.ui.home.HomeUiState> getUiState() {
        return null;
    }
    
    /**
     * Observe DB projects and store them; apply filters reactively
     */
    private final void loadProjects() {
    }
    
    /**
     * Reactively re-filter whenever query or status changes
     */
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    private final void observeFilters() {
    }
    
    public final void onSearchQueryChange(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void onFilterSelected(@org.jetbrains.annotations.Nullable()
    com.gramssuvidha.portal.domain.model.ProjectStatus status) {
    }
    
    private final void applyFilters() {
    }
    
    public final void onRefresh() {
    }
    
    public final void refreshFromNetwork() {
    }
    
    private final void startInsightRotation() {
    }
    
    public final void dismissError() {
    }
}