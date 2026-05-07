package com.gramssuvidha.portal.domain.repository;

/**
 * Repository interface for AI-powered features.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/gramssuvidha/portal/domain/repository/AIRepository;", "", "categorizeIssue", "", "issueText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateProgressSummary", "projectTitle", "progress", "", "status", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVillageInsights", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public abstract interface AIRepository {
    
    /**
     * Generate a human-readable progress summary for a project
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object generateProgressSummary(@org.jetbrains.annotations.NotNull()
    java.lang.String projectTitle, int progress, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    /**
     * Categorize a citizen-submitted issue
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object categorizeIssue(@org.jetbrains.annotations.NotNull()
    java.lang.String issueText, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    /**
     * Generate village-wide smart insights
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getVillageInsights();
}