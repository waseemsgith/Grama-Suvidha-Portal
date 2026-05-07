package com.gramssuvidha.portal.data.remote.api;

/**
 * Retrofit API service interface for the Grama Suvidha backend.
 * In this version, requests are intercepted by MockApiInterceptor.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/gramssuvidha/portal/data/remote/api/GramaSuvidhaApiService;", "", "getProjectUpdates", "Lcom/gramssuvidha/portal/data/remote/model/ProjectUpdatesResponse;", "projectId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjects", "Lcom/gramssuvidha/portal/data/remote/model/ProjectsResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitFeedback", "Lcom/gramssuvidha/portal/data/remote/model/FeedbackResponse;", "feedback", "Lcom/gramssuvidha/portal/data/remote/model/FeedbackDto;", "(Lcom/gramssuvidha/portal/data/remote/model/FeedbackDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GramaSuvidhaApiService {
    
    @retrofit2.http.GET(value = "api/v1/projects")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProjects(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.data.remote.model.ProjectsResponse> $completion);
    
    @retrofit2.http.GET(value = "api/v1/projects/{id}/updates")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProjectUpdates(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String projectId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.data.remote.model.ProjectUpdatesResponse> $completion);
    
    @retrofit2.http.POST(value = "api/v1/feedback")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object submitFeedback(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.remote.model.FeedbackDto feedback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.data.remote.model.FeedbackResponse> $completion);
}