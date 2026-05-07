package com.gramssuvidha.portal.data.remote.api;

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
public final class MockApiInterceptor_Factory implements Factory<MockApiInterceptor> {
  @Override
  public MockApiInterceptor get() {
    return newInstance();
  }

  public static MockApiInterceptor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MockApiInterceptor newInstance() {
    return new MockApiInterceptor();
  }

  private static final class InstanceHolder {
    private static final MockApiInterceptor_Factory INSTANCE = new MockApiInterceptor_Factory();
  }
}
