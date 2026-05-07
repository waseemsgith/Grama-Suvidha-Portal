package com.gramssuvidha.portal;

import com.gramssuvidha.portal.utils.LanguageUtils;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<LanguageUtils> languageUtilsProvider;

  public MainActivity_MembersInjector(Provider<LanguageUtils> languageUtilsProvider) {
    this.languageUtilsProvider = languageUtilsProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<LanguageUtils> languageUtilsProvider) {
    return new MainActivity_MembersInjector(languageUtilsProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectLanguageUtils(instance, languageUtilsProvider.get());
  }

  @InjectedFieldSignature("com.gramssuvidha.portal.MainActivity.languageUtils")
  public static void injectLanguageUtils(MainActivity instance, LanguageUtils languageUtils) {
    instance.languageUtils = languageUtils;
  }
}
