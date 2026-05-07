package com.gramssuvidha.portal.di;

import com.gramssuvidha.portal.data.local.GramaSuvidhaDatabase;
import com.gramssuvidha.portal.data.local.dao.FeedbackDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideFeedbackDaoFactory implements Factory<FeedbackDao> {
  private final Provider<GramaSuvidhaDatabase> dbProvider;

  public DatabaseModule_ProvideFeedbackDaoFactory(Provider<GramaSuvidhaDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FeedbackDao get() {
    return provideFeedbackDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideFeedbackDaoFactory create(
      Provider<GramaSuvidhaDatabase> dbProvider) {
    return new DatabaseModule_ProvideFeedbackDaoFactory(dbProvider);
  }

  public static FeedbackDao provideFeedbackDao(GramaSuvidhaDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFeedbackDao(db));
  }
}
