package com.gramssuvidha.portal.domain.usecase;

import com.gramssuvidha.portal.domain.repository.ProjectRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class GetProjectsUseCase_Factory implements Factory<GetProjectsUseCase> {
  private final Provider<ProjectRepository> repositoryProvider;

  public GetProjectsUseCase_Factory(Provider<ProjectRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetProjectsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetProjectsUseCase_Factory create(Provider<ProjectRepository> repositoryProvider) {
    return new GetProjectsUseCase_Factory(repositoryProvider);
  }

  public static GetProjectsUseCase newInstance(ProjectRepository repository) {
    return new GetProjectsUseCase(repository);
  }
}
