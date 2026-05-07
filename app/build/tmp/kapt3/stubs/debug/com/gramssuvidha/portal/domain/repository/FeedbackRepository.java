package com.gramssuvidha.portal.domain.repository;

/**
 * Repository interface for citizen feedback operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/gramssuvidha/portal/domain/repository/FeedbackRepository;", "", "getFeedbackForProject", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gramssuvidha/portal/utils/Resource;", "", "Lcom/gramssuvidha/portal/domain/model/Feedback;", "projectId", "", "submitFeedback", "", "feedback", "(Lcom/gramssuvidha/portal/domain/model/Feedback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncPendingFeedback", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FeedbackRepository {
    
    /**
     * Submit or queue feedback (offline-first)
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object submitFeedback(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.Feedback feedback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion);
    
    /**
     * Get all feedback for a project
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.Feedback>>> getFeedbackForProject(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId);
    
    /**
     * Sync pending (offline) feedback to remote
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object syncPendingFeedback(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion);
}