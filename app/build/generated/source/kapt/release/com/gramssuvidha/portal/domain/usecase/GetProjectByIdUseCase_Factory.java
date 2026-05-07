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
public final class GetProjectByIdUseCase_Factory implements Factory<GetProjectByIdUseCase> {
  private final Provider<ProjectRepository> repositoryProvider;

  public GetProjectByIdUseCase_Factory(Provider<ProjectRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetProjectByIdUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetProjectByIdUseCase_Factory create(
      Provider<ProjectRepository> repositoryProvider) {
    return new GetProjectByIdUseCase_Factory(repositoryProvider);
  }

  public static GetProjectByIdUseCase newInstance(ProjectRepository repository) {
    return new GetProjectByIdUseCase(repository);
  }
}
