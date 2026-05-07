package com.gramssuvidha.portal.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class LanguageUtils_Factory implements Factory<LanguageUtils> {
  private final Provider<Context> contextProvider;

  public LanguageUtils_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public LanguageUtils get() {
    return newInstance(contextProvider.get());
  }

  public static LanguageUtils_Factory create(Provider<Context> contextProvider) {
    return new LanguageUtils_Factory(contextProvider);
  }

  public static LanguageUtils newInstance(Context context) {
    return new LanguageUtils(context);
  }
}
