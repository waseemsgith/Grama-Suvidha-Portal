package com.gramssuvidha.portal.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AIRepositoryImpl_Factory implements Factory<AIRepositoryImpl> {
  @Override
  public AIRepositoryImpl get() {
    return newInstance();
  }

  public static AIRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AIRepositoryImpl newInstance() {
    return new AIRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final AIRepositoryImpl_Factory INSTANCE = new AIRepositoryImpl_Factory();
  }
}
