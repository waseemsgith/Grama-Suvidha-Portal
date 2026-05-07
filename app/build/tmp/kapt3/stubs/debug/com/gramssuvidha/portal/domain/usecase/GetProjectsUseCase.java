package com.gramssuvidha.portal.domain.usecase;

/**
 * Use case that retrieves and optionally filters projects by status/search query.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/gramssuvidha/portal/domain/usecase/GetProjectsUseCase;", "", "repository", "Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "(Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gramssuvidha/portal/utils/Resource;", "", "Lcom/gramssuvidha/portal/domain/model/Project;", "query", "", "statusFilter", "Lcom/gramssuvidha/portal/domain/model/ProjectStatus;", "app_debug"})
public final class GetProjectsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.ProjectRepository repository = null;
    
    @javax.inject.Inject()
    public GetProjectsUseCase(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.ProjectRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<java.util.List<com.gramssuvidha.portal.domain.model.Project>>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    com.gramssuvidha.portal.domain.model.ProjectStatus statusFilter) {
        return null;
    }
}