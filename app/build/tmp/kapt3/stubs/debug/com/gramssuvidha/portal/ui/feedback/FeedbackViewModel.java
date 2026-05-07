package com.gramssuvidha.portal.ui.feedback;

/**
 * ViewModel for the Feedback screen.
 * Handles form state, validation, AI categorization, and submission.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\u0019J\b\u0010)\u001a\u00020*H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006+"}, d2 = {"Lcom/gramssuvidha/portal/ui/feedback/FeedbackViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "submitFeedbackUseCase", "Lcom/gramssuvidha/portal/domain/usecase/SubmitFeedbackUseCase;", "aiRepository", "Lcom/gramssuvidha/portal/domain/repository/AIRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/gramssuvidha/portal/domain/usecase/SubmitFeedbackUseCase;Lcom/gramssuvidha/portal/domain/repository/AIRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/gramssuvidha/portal/ui/feedback/FeedbackUiState;", "aiJob", "Lkotlinx/coroutines/Job;", "projectId", "", "getProjectId", "()Ljava/lang/String;", "projectTitle", "getProjectTitle", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "categorizeComment", "", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCommentChange", "comment", "onContactChange", "contact", "onIssueTypeSelected", "issueType", "Lcom/gramssuvidha/portal/domain/model/IssueType;", "onNameChange", "name", "onRatingChange", "rating", "", "submitFeedback", "validate", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FeedbackViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.usecase.SubmitFeedbackUseCase submitFeedbackUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.AIRepository aiRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String projectId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String projectTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gramssuvidha.portal.ui.feedback.FeedbackUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.gramssuvidha.portal.ui.feedback.FeedbackUiState> uiState = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job aiJob;
    
    @javax.inject.Inject()
    public FeedbackViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.usecase.SubmitFeedbackUseCase submitFeedbackUseCase, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.AIRepository aiRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProjectId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProjectTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.gramssuvidha.portal.ui.feedback.FeedbackUiState> getUiState() {
        return null;
    }
    
    public final void onRatingChange(int rating) {
    }
    
    public final void onCommentChange(@org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
    }
    
    public final void onNameChange(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void onContactChange(@org.jetbrains.annotations.NotNull()
    java.lang.String contact) {
    }
    
    public final void onIssueTypeSelected(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.IssueType issueType) {
    }
    
    private final java.lang.Object categorizeComment(java.lang.String text, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void submitFeedback() {
    }
    
    private final boolean validate() {
        return false;
    }
}