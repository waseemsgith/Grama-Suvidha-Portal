package com.gramssuvidha.portal.domain.repository;

/**
 * Repository interface for project data operations.
 * Follows the single source of truth principle.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\u001a\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00040\u0003H&J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "", "getProjectById", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gramssuvidha/portal/utils/Resource;", "Lcom/gramssuvidha/portal/domain/model/Project;", "id", "", "getProjectUpdates", "", "Lcom/gramssuvidha/portal/domain/model/ProjectUpdate;", "projectId", "getProjects", "refreshProjects", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface ProjectRepository {
    
    /**
     * Observe all cached projects as a Flow
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.Project>>> getProjects();
    
    /**
     * Get a single project by ID
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<com.gramssuvidha.portal.domain.model.Project>> getProjectById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    /**
     * Get timeline updates for a project
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.ProjectUpdate>>> getProjectUpdates(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId);
    
    /**
     * Force-refresh projects from network
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshProjects(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion);
}