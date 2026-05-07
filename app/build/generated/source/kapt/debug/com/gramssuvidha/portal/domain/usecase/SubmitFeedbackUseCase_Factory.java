package com.gramssuvidha.portal.domain.usecase;

import com.gramssuvidha.portal.domain.repository.AIRepository;
import com.gramssuvidha.portal.domain.repository.FeedbackRepository;
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
public final class SubmitFeedbackUseCase_Factory implements Factory<SubmitFeedbackUseCase> {
  private final Provider<FeedbackRepository> feedbackRepositoryProvider;

  private final Provider<AIRepository> aiRepositoryProvider;

  public SubmitFeedbackUseCase_Factory(Provider<FeedbackRepository> feedbackRepositoryProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    this.feedbackRepositoryProvider = feedbackRepositoryProvider;
    this.aiRepositoryProvider = aiRepositoryProvider;
  }

  @Override
  public SubmitFeedbackUseCase get() {
    return newInstance(feedbackRepositoryProvider.get(), aiRepositoryProvider.get());
  }

  public static SubmitFeedbackUseCase_Factory create(
      Provider<FeedbackRepository> feedbackRepositoryProvider,
      Provider<AIRepository> aiRepositoryProvider) {
    return new SubmitFeedbackUseCase_Factory(feedbackRepositoryProvider, aiRepositoryProvider);
  }

  public static SubmitFeedbackUseCase newInstance(FeedbackRepository feedbackRepository,
      AIRepository aiRepository) {
    return new SubmitFeedbackUseCase(feedbackRepository, aiRepository);
  }
}
