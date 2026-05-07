package com.gramssuvidha.portal.ui.settings;

import com.gramssuvidha.portal.utils.LanguageUtils;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<LanguageUtils> languageUtilsProvider;

  public SettingsViewModel_Factory(Provider<LanguageUtils> languageUtilsProvider) {
    this.languageUtilsProvider = languageUtilsProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(languageUtilsProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<LanguageUtils> languageUtilsProvider) {
    return new SettingsViewModel_Factory(languageUtilsProvider);
  }

  public static SettingsViewModel newInstance(LanguageUtils languageUtils) {
    return new SettingsViewModel(languageUtils);
  }
}
