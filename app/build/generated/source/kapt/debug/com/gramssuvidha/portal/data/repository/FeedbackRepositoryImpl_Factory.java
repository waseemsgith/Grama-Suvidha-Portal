package com.gramssuvidha.portal.data.repository;

import com.gramssuvidha.portal.data.local.dao.FeedbackDao;
import com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class FeedbackRepositoryImpl_Factory implements Factory<FeedbackRepositoryImpl> {
  private final Provider<FeedbackDao> feedbackDaoProvider;

  private final Provider<GramaSuvidhaApiService> apiServiceProvider;

  public FeedbackRepositoryImpl_Factory(Provider<FeedbackDao> feedbackDaoProvider,
      Provider<GramaSuvidhaApiService> apiServiceProvider) {
    this.feedbackDaoProvider = feedbackDaoProvider;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public FeedbackRepositoryImpl get() {
    return newInstance(feedbackDaoProvider.get(), apiServiceProvider.get());
  }

  public static FeedbackRepositoryImpl_Factory create(Provider<FeedbackDao> feedbackDaoProvider,
      Provider<GramaSuvidhaApiService> apiServiceProvider) {
    return new FeedbackRepositoryImpl_Factory(feedbackDaoProvider, apiServiceProvider);
  }

  public static FeedbackRepositoryImpl newInstance(FeedbackDao feedbackDao,
      GramaSuvidhaApiService apiService) {
    return new FeedbackRepositoryImpl(feedbackDao, apiService);
  }
}
