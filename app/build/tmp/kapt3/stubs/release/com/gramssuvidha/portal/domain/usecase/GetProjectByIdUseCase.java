package com.gramssuvidha.portal.domain.usecase;

/**
 * Use case that retrieves a single project by its ID.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/gramssuvidha/portal/domain/usecase/GetProjectByIdUseCase;", "", "repository", "Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "(Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gramssuvidha/portal/utils/Resource;", "Lcom/gramssuvidha/portal/domain/model/Project;", "id", "", "app_release"})
public final class GetProjectByIdUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.repository.ProjectRepository repository = null;
    
    @javax.inject.Inject()
    public GetProjectByIdUseCase(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.repository.ProjectRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.utils.Resource<com.gramssuvidha.portal.domain.model.Project>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
}