package com.gramssuvidha.portal.ui.home;

import com.gramssuvidha.portal.domain.repository.AIRepository;
import com.gramssuvidha.portal.domain.repository.ProjectRepository;
import com.gramssuvidha.portal.domain.usecase.GetProjectsUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetProjectsUseCase> getProjectsUseCaseProvider;

  private final Provider<ProjectRepository> projectRepositoryProvider;

  private final Provider<AIRepository> aiRepositoryProvider;

  public HomeViewModel_Factory(Provider<GetProjectsUseCase> getProjectsUseCaseProvider,
      Provider<ProjectRepository> projectRepositoryProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    this.getProjectsUseCaseProvider = getProjectsUseCaseProvider;
    this.projectRepositoryProvider = projectRepositoryProvider;
    this.aiRepositoryProvider = aiRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getProjectsUseCaseProvider.get(), projectRepositoryProvider.get(), aiRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetProjectsUseCase> getProjectsUseCaseProvider,
      Provider<ProjectRepository> projectRepositoryProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    return new HomeViewModel_Factory(getProjectsUseCaseProvider, projectRepositoryProvider, aiRepositoryProvider);
  }

  public static HomeViewModel newInstance(GetProjectsUseCase getProjectsUseCase,
      ProjectRepository projectRepository, AIRepository aiRepository) {
    return new HomeViewModel(getProjectsUseCase, projectRepository, aiRepository);
  }
}
