package com.gramssuvidha.portal.data.repository;

/**
 * Concrete implementation of [ProjectRepository].
 * Uses Room as the single source of truth with network as a refresh source.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001a\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000b0\nH\u0016J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/gramssuvidha/portal/data/repository/ProjectRepositoryImpl;", "Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "projectDao", "Lcom/gramssuvidha/portal/data/local/dao/ProjectDao;", "projectUpdateDao", "Lcom/gramssuvidha/portal/data/local/dao/ProjectUpdateDao;", "apiService", "Lcom/gramssuvidha/portal/data/remote/api/GramaSuvidhaApiService;", "(Lcom/gramssuvidha/portal/data/local/dao/ProjectDao;Lcom/gramssuvidha/portal/data/local/dao/ProjectUpdateDao;Lcom/gramssuvidha/portal/data/remote/api/GramaSuvidhaApiService;)V", "getProjectById", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gramssuvidha/portal/utils/Resource;", "Lcom/gramssuvidha/portal/domain/model/Project;", "id", "", "getProjectUpdates", "", "Lcom/gramssuvidha/portal/domain/model/ProjectUpdate;", "projectId", "getProjects", "refreshProjects", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ProjectRepositoryImpl implements com.gramssuvidha.portal.domain.repository.ProjectRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.data.local.dao.ProjectDao projectDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao projectUpdateDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService apiService = null;
    
    @javax.inject.Inject()
    public ProjectRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.local.dao.ProjectDao projectDao, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao projectUpdateDao, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.Project>>> getProjects() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<com.gramssuvidha.portal.domain.model.Project>> getProjectById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.ProjectUpdate>>> getProjectUpdates(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshProjects(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gramssuvidha.portal.utils.Resource<kotlin.Unit>> $completion) {
        return null;
    }
}