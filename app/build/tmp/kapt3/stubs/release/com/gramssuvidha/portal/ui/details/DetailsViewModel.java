package com.gramssuvidha.portal.ui.details;

/**
 * ViewModel for the Project Details screen.
 * Loads project, updates, and AI summary.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/gramssuvidha/portal/ui/details/DetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "getProjectByIdUseCase", "Lcom/gramssuvidha/portal/domain/usecase/GetProjectByIdUseCase;", "projectRepository", "Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "aiRepository", "Lcom/gramssuvidha/portal/domain/repository/AIRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/gramssuvidha/portal/domain/usecase/GetProjectByIdUseCase;Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;Lcom/gramssuvidha/portal/domain/repository/AIRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/gramssuvidha/portal/ui/details/DetailsUiState;", "projectId", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "generateAiSummary", "", "title", "progress", "", "status", "loadProject", "loadUpdates", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.usecase.GetProjectByIdUseCase getProjectByIdUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.ProjectRepository projectRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.AIRepository aiRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String projectId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gramssuvidha.portal.ui.details.DetailsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.gramssuvidha.portal.ui.details.DetailsUiState> uiState = null;
    
    @javax.inject.Inject()
    public DetailsViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.usecase.GetProjectByIdUseCase getProjectByIdUseCase, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.ProjectRepository projectRepository, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.AIRepository aiRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.gramssuvidha.portal.ui.details.DetailsUiState> getUiState() {
        return null;
    }
    
    private final void loadProject() {
    }
    
    private final void loadUpdates() {
    }
    
    private final void generateAiSummary(java.lang.String title, int progress, java.lang.String status) {
    }
}