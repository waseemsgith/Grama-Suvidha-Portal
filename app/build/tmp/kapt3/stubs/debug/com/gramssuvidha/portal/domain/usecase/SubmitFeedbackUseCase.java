package com.gramssuvidha.portal.domain.usecase;

/**
 * Use case that submits citizen feedback with AI issue categorization.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086B\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/gramssuvidha/portal/domain/usecase/SubmitFeedbackUseCase;", "", "feedbackRepository", "Lcom/gramssuvidha/portal/domain/repository/FeedbackRepository;", "aiRepository", "Lcom/gramssuvidha/portal/domain/repository/AIRepository;", "(Lcom/gramssuvidha/portal/domain/repository/FeedbackRepository;Lcom/gramssuvidha/portal/domain/repository/AIRepository;)V", "invoke", "Lcom/gramssuvidha/portal/utils/Resource;", "", "feedback", "Lcom/gramssuvidha/portal/domain/model/Feedback;", "(Lcom/gramssuvidha/portal/domain/model/Feedback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SubmitFeedbackUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.FeedbackRepository feedbackRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.AIRepository aiRepository = null;
    
    @javax.inject.Inject()
    public SubmitFeedbackUseCase(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.FeedbackRepository feedbackRepository, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.AIRepository aiRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.Feedback feedback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion) {
        return null;
    }
}