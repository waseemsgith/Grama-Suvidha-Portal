package com.gramssuvidha.portal.ui.details;

import androidx.lifecycle.SavedStateHandle;
import com.gramssuvidha.portal.domain.repository.AIRepository;
import com.gramssuvidha.portal.domain.repository.ProjectRepository;
import com.gramssuvidha.portal.domain.usecase.GetProjectByIdUseCase;
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
public final class DetailsViewModel_Factory implements Factory<DetailsViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<GetProjectByIdUseCase> getProjectByIdUseCaseProvider;

  private final Provider<ProjectRepository> projectRepositoryProvider;

  private final Provider<AIRepository> aiRepositoryProvider;

  public DetailsViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<GetProjectByIdUseCase> getProjectByIdUseCaseProvider,
      Provider<ProjectRepository> projectRepositoryProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.getProjectByIdUseCaseProvider = getProjectByIdUseCaseProvider;
    this.projectRepositoryProvider = projectRepositoryProvider;
    this.aiRepositoryProvider = aiRepositoryProvider;
  }

  @Override
  public DetailsViewModel get() {
    return newInstance(savedStateHandleProvider.get(), getProjectByIdUseCaseProvider.get(), projectRepositoryProvider.get(), aiRepositoryProvider.get());
  }

  public static DetailsViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<GetProjectByIdUseCase> getProjectByIdUseCaseProvider,
      Provider<ProjectRepository> projectRepositoryProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    return new DetailsViewModel_Factory(savedStateHandleProvider, getProjectByIdUseCaseProvider, projectRepositoryProvider, aiRepositoryProvider);
  }

  public static DetailsViewModel newInstance(SavedStateHandle savedStateHandle,
      GetProjectByIdUseCase getProjectByIdUseCase, ProjectRepository projectRepository,
      AIRepository aiRepository) {
    return new DetailsViewModel(savedStateHandle, getProjectByIdUseCase, projectRepository, aiRepository);
  }
}
