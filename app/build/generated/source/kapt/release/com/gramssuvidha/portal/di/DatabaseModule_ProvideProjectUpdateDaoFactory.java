package com.gramssuvidha.portal.di;

import com.gramssuvidha.portal.data.local.GramaSuvidhaDatabase;
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao;
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
public final class DatabaseModule_ProvideProjectUpdateDaoFactory implements Factory<ProjectUpdateDao> {
  private final Provider<GramaSuvidhaDatabase> dbProvider;

  public DatabaseModule_ProvideProjectUpdateDaoFactory(Provider<GramaSuvidhaDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ProjectUpdateDao get() {
    return provideProjectUpdateDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideProjectUpdateDaoFactory create(
      Provider<GramaSuvidhaDatabase> dbProvider) {
    return new DatabaseModule_ProvideProjectUpdateDaoFactory(dbProvider);
  }

  public static ProjectUpdateDao provideProjectUpdateDao(GramaSuvidhaDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideProjectUpdateDao(db));
  }
}
