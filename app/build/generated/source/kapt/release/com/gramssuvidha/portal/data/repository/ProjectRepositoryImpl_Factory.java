package com.gramssuvidha.portal.data.repository;

import com.gramssuvidha.portal.data.local.dao.ProjectDao;
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao;
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
public final class ProjectRepositoryImpl_Factory implements Factory<ProjectRepositoryImpl> {
  private final Provider<ProjectDao> projectDaoProvider;

  private final Provider<ProjectUpdateDao> projectUpdateDaoProvider;

  private final Provider<GramaSuvidhaApiService> apiServiceProvider;

  public ProjectRepositoryImpl_Factory(Provider<ProjectDao> projectDaoProvider,
      Provider<ProjectUpdateDao> projectUpdateDaoProvider,
      Provider<GramaSuvidhaApiService> apiServiceProvider) {
    this.projectDaoProvider = projectDaoProvider;
    this.projectUpdateDaoProvider = projectUpdateDaoProvider;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ProjectRepositoryImpl get() {
    return newInstance(projectDaoProvider.get(), projectUpdateDaoProvider.get(), apiServiceProvider.get());
  }

  public static ProjectRepositoryImpl_Factory create(Provider<ProjectDao> projectDaoProvider,
      Provider<ProjectUpdateDao> projectUpdateDaoProvider,
      Provider<GramaSuvidhaApiService> apiServiceProvider) {
    return new ProjectRepositoryImpl_Factory(projectDaoProvider, projectUpdateDaoProvider, apiServiceProvider);
  }

  public static ProjectRepositoryImpl newInstance(ProjectDao projectDao,
      ProjectUpdateDao projectUpdateDao, GramaSuvidhaApiService apiService) {
    return new ProjectRepositoryImpl(projectDao, projectUpdateDao, apiService);
  }
}
