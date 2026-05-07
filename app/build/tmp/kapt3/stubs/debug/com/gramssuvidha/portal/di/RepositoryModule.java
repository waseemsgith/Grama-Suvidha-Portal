package com.gramssuvidha.portal.di;

/**
 * Hilt module binding domain repository interfaces to their implementations.
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/gramssuvidha/portal/di/RepositoryModule;", "", "()V", "bindAIRepository", "Lcom/gramssuvidha/portal/domain/repository/AIRepository;", "impl", "Lcom/gramssuvidha/portal/data/repository/AIRepositoryImpl;", "bindFeedbackRepository", "Lcom/gramssuvidha/portal/domain/repository/FeedbackRepository;", "Lcom/gramssuvidha/portal/data/repository/FeedbackRepositoryImpl;", "bindProjectRepository", "Lcom/gramssuvidha/portal/domain/repository/ProjectRepository;", "Lcom/gramssuvidha/portal/data/repository/ProjectRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.gramssuvidha.portal.domain.repository.ProjectRepository bindProjectRepository(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.repository.ProjectRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.gramssuvidha.portal.domain.repository.FeedbackRepository bindFeedbackRepository(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.repository.FeedbackRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.gramssuvidha.portal.domain.repository.AIRepository bindAIRepository(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.repository.AIRepositoryImpl impl);
}