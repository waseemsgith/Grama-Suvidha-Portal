package com.gramssuvidha.portal.ui.feedback;

import androidx.lifecycle.SavedStateHandle;
import com.gramssuvidha.portal.domain.repository.AIRepository;
import com.gramssuvidha.portal.domain.usecase.SubmitFeedbackUseCase;
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
public final class FeedbackViewModel_Factory implements Factory<FeedbackViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<SubmitFeedbackUseCase> submitFeedbackUseCaseProvider;

  private final Provider<AIRepository> aiRepositoryProvider;

  public FeedbackViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<SubmitFeedbackUseCase> submitFeedbackUseCaseProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.submitFeedbackUseCaseProvider = submitFeedbackUseCaseProvider;
    this.aiRepositoryProvider = aiRepositoryProvider;
  }

  @Override
  public FeedbackViewModel get() {
    return newInstance(savedStateHandleProvider.get(), submitFeedbackUseCaseProvider.get(), aiRepositoryProvider.get());
  }

  public static FeedbackViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<SubmitFeedbackUseCase> submitFeedbackUseCaseProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    return new FeedbackViewModel_Factory(savedStateHandleProvider, submitFeedbackUseCaseProvider, aiRepositoryProvider);
  }

  public static FeedbackViewModel newInstance(SavedStateHandle savedStateHandle,
      SubmitFeedbackUseCase submitFeedbackUseCase, AIRepository aiRepository) {
    return new FeedbackViewModel(savedStateHandle, submitFeedbackUseCase, aiRepository);
  }
}
