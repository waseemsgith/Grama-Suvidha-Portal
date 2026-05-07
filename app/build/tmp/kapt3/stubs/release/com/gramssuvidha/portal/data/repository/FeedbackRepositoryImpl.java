package com.gramssuvidha.portal.data.repository;

/**
 * Offline-first feedback repository.
 * Saves feedback locally first, then syncs to remote when online.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/gramssuvidha/portal/data/repository/FeedbackRepositoryImpl;", "Lcom/gramssuvidha/portal/domain/repository/FeedbackRepository;", "feedbackDao", "Lcom/gramssuvidha/portal/data/local/dao/FeedbackDao;", "apiService", "Lcom/gramssuvidha/portal/data/remote/api/GramaSuvidhaApiService;", "(Lcom/gramssuvidha/portal/data/local/dao/FeedbackDao;Lcom/gramssuvidha/portal/data/remote/api/GramaSuvidhaApiService;)V", "getFeedbackForProject", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gramssuvidha/portal/utils/Resource;", "", "Lcom/gramssuvidha/portal/domain/model/Feedback;", "projectId", "", "submitFeedback", "", "feedback", "(Lcom/gramssuvidha/portal/domain/model/Feedback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncPendingFeedback", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class FeedbackRepositoryImpl implements com.gramssuvidha.portal.domain.repository.FeedbackRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.data.local.dao.FeedbackDao feedbackDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService apiService = null;
    
    @javax.inject.Inject()
    public FeedbackRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.local.dao.FeedbackDao feedbackDao, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object submitFeedback(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.Feedback feedback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.Feedback>>> getFeedbackForProject(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object syncPendingFeedback(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion) {
        return null;
    }
}