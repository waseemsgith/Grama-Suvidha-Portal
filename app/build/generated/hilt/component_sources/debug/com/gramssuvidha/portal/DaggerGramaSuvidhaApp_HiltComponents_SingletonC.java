package com.gramssuvidha.portal;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.gramssuvidha.portal.data.local.GramaSuvidhaDatabase;
import com.gramssuvidha.portal.data.local.dao.FeedbackDao;
import com.gramssuvidha.portal.data.local.dao.ProjectDao;
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao;
import com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService;
import com.gramssuvidha.portal.data.remote.api.MockApiInterceptor;
import com.gramssuvidha.portal.data.repository.AIRepositoryImpl;
import com.gramssuvidha.portal.data.repository.FeedbackRepositoryImpl;
import com.gramssuvidha.portal.data.repository.ProjectRepositoryImpl;
import com.gramssuvidha.portal.di.DatabaseModule_ProvideDatabaseFactory;
import com.gramssuvidha.portal.di.DatabaseModule_ProvideFeedbackDaoFactory;
import com.gramssuvidha.portal.di.DatabaseModule_ProvideProjectDaoFactory;
import com.gramssuvidha.portal.di.DatabaseModule_ProvideProjectUpdateDaoFactory;
import com.gramssuvidha.portal.di.NetworkModule_ProvideApiServiceFactory;
import com.gramssuvidha.portal.di.NetworkModule_ProvideLoggingInterceptorFactory;
import com.gramssuvidha.portal.di.NetworkModule_ProvideOkHttpClientFactory;
import com.gramssuvidha.portal.di.NetworkModule_ProvideRetrofitFactory;
import com.gramssuvidha.portal.domain.usecase.GetProjectByIdUseCase;
import com.gramssuvidha.portal.domain.usecase.GetProjectsUseCase;
import com.gramssuvidha.portal.domain.usecase.SubmitFeedbackUseCase;
import com.gramssuvidha.portal.ui.details.DetailsViewModel;
import com.gramssuvidha.portal.ui.details.DetailsViewModel_HiltModules;
import com.gramssuvidha.portal.ui.feedback.FeedbackViewModel;
import com.gramssuvidha.portal.ui.feedback.FeedbackViewModel_HiltModules;
import com.gramssuvidha.portal.ui.home.HomeViewModel;
import com.gramssuvidha.portal.ui.home.HomeViewModel_HiltModules;
import com.gramssuvidha.portal.ui.settings.SettingsViewModel;
import com.gramssuvidha.portal.ui.settings.SettingsViewModel_HiltModules;
import com.gramssuvidha.portal.utils.LanguageUtils;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

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
public final class DaggerGramaSuvidhaApp_HiltComponents_SingletonC {
  private DaggerGramaSuvidhaApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public GramaSuvidhaApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements GramaSuvidhaApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements GramaSuvidhaApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements GramaSuvidhaApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements GramaSuvidhaApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements GramaSuvidhaApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements GramaSuvidhaApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements GramaSuvidhaApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public GramaSuvidhaApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends GramaSuvidhaApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends GramaSuvidhaApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends GramaSuvidhaApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends GramaSuvidhaApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
      injectMainActivity2(mainActivity);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(4).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_details_DetailsViewModel, DetailsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_feedback_FeedbackViewModel, FeedbackViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_home_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_settings_SettingsViewModel, SettingsViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity2(MainActivity instance) {
      MainActivity_MembersInjector.injectLanguageUtils(instance, singletonCImpl.languageUtilsProvider.get());
      return instance;
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_gramssuvidha_portal_ui_feedback_FeedbackViewModel = "com.gramssuvidha.portal.ui.feedback.FeedbackViewModel";

      static String com_gramssuvidha_portal_ui_details_DetailsViewModel = "com.gramssuvidha.portal.ui.details.DetailsViewModel";

      static String com_gramssuvidha_portal_ui_settings_SettingsViewModel = "com.gramssuvidha.portal.ui.settings.SettingsViewModel";

      static String com_gramssuvidha_portal_ui_home_HomeViewModel = "com.gramssuvidha.portal.ui.home.HomeViewModel";

      @KeepFieldType
      FeedbackViewModel com_gramssuvidha_portal_ui_feedback_FeedbackViewModel2;

      @KeepFieldType
      DetailsViewModel com_gramssuvidha_portal_ui_details_DetailsViewModel2;

      @KeepFieldType
      SettingsViewModel com_gramssuvidha_portal_ui_settings_SettingsViewModel2;

      @KeepFieldType
      HomeViewModel com_gramssuvidha_portal_ui_home_HomeViewModel2;
    }
  }

  private static final class ViewModelCImpl extends GramaSuvidhaApp_HiltComponents.ViewModelC {
    private final SavedStateHandle savedStateHandle;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<DetailsViewModel> detailsViewModelProvider;

    private Provider<FeedbackViewModel> feedbackViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.savedStateHandle = savedStateHandleParam;
      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private GetProjectByIdUseCase getProjectByIdUseCase() {
      return new GetProjectByIdUseCase(singletonCImpl.projectRepositoryImplProvider.get());
    }

    private SubmitFeedbackUseCase submitFeedbackUseCase() {
      return new SubmitFeedbackUseCase(singletonCImpl.feedbackRepositoryImplProvider.get(), singletonCImpl.aIRepositoryImplProvider.get());
    }

    private GetProjectsUseCase getProjectsUseCase() {
      return new GetProjectsUseCase(singletonCImpl.projectRepositoryImplProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.detailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.feedbackViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(4).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_details_DetailsViewModel, ((Provider) detailsViewModelProvider)).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_feedback_FeedbackViewModel, ((Provider) feedbackViewModelProvider)).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_home_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.com_gramssuvidha_portal_ui_settings_SettingsViewModel, ((Provider) settingsViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_gramssuvidha_portal_ui_feedback_FeedbackViewModel = "com.gramssuvidha.portal.ui.feedback.FeedbackViewModel";

      static String com_gramssuvidha_portal_ui_details_DetailsViewModel = "com.gramssuvidha.portal.ui.details.DetailsViewModel";

      static String com_gramssuvidha_portal_ui_home_HomeViewModel = "com.gramssuvidha.portal.ui.home.HomeViewModel";

      static String com_gramssuvidha_portal_ui_settings_SettingsViewModel = "com.gramssuvidha.portal.ui.settings.SettingsViewModel";

      @KeepFieldType
      FeedbackViewModel com_gramssuvidha_portal_ui_feedback_FeedbackViewModel2;

      @KeepFieldType
      DetailsViewModel com_gramssuvidha_portal_ui_details_DetailsViewModel2;

      @KeepFieldType
      HomeViewModel com_gramssuvidha_portal_ui_home_HomeViewModel2;

      @KeepFieldType
      SettingsViewModel com_gramssuvidha_portal_ui_settings_SettingsViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.gramssuvidha.portal.ui.details.DetailsViewModel 
          return (T) new DetailsViewModel(viewModelCImpl.savedStateHandle, viewModelCImpl.getProjectByIdUseCase(), singletonCImpl.projectRepositoryImplProvider.get(), singletonCImpl.aIRepositoryImplProvider.get());

          case 1: // com.gramssuvidha.portal.ui.feedback.FeedbackViewModel 
          return (T) new FeedbackViewModel(viewModelCImpl.savedStateHandle, viewModelCImpl.submitFeedbackUseCase(), singletonCImpl.aIRepositoryImplProvider.get());

          case 2: // com.gramssuvidha.portal.ui.home.HomeViewModel 
          return (T) new HomeViewModel(viewModelCImpl.getProjectsUseCase(), singletonCImpl.projectRepositoryImplProvider.get(), singletonCImpl.aIRepositoryImplProvider.get());

          case 3: // com.gramssuvidha.portal.ui.settings.SettingsViewModel 
          return (T) new SettingsViewModel(singletonCImpl.languageUtilsProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends GramaSuvidhaApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends GramaSuvidhaApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends GramaSuvidhaApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<LanguageUtils> languageUtilsProvider;

    private Provider<GramaSuvidhaDatabase> provideDatabaseProvider;

    private Provider<MockApiInterceptor> mockApiInterceptorProvider;

    private Provider<HttpLoggingInterceptor> provideLoggingInterceptorProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<GramaSuvidhaApiService> provideApiServiceProvider;

    private Provider<ProjectRepositoryImpl> projectRepositoryImplProvider;

    private Provider<AIRepositoryImpl> aIRepositoryImplProvider;

    private Provider<FeedbackRepositoryImpl> feedbackRepositoryImplProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private ProjectDao projectDao() {
      return DatabaseModule_ProvideProjectDaoFactory.provideProjectDao(provideDatabaseProvider.get());
    }

    private ProjectUpdateDao projectUpdateDao() {
      return DatabaseModule_ProvideProjectUpdateDaoFactory.provideProjectUpdateDao(provideDatabaseProvider.get());
    }

    private FeedbackDao feedbackDao() {
      return DatabaseModule_ProvideFeedbackDaoFactory.provideFeedbackDao(provideDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.languageUtilsProvider = DoubleCheck.provider(new SwitchingProvider<LanguageUtils>(singletonCImpl, 0));
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<GramaSuvidhaDatabase>(singletonCImpl, 2));
      this.mockApiInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<MockApiInterceptor>(singletonCImpl, 6));
      this.provideLoggingInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<HttpLoggingInterceptor>(singletonCImpl, 7));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 5));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 4));
      this.provideApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<GramaSuvidhaApiService>(singletonCImpl, 3));
      this.projectRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<ProjectRepositoryImpl>(singletonCImpl, 1));
      this.aIRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AIRepositoryImpl>(singletonCImpl, 8));
      this.feedbackRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<FeedbackRepositoryImpl>(singletonCImpl, 9));
    }

    @Override
    public void injectGramaSuvidhaApp(GramaSuvidhaApp gramaSuvidhaApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.gramssuvidha.portal.utils.LanguageUtils 
          return (T) new LanguageUtils(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.gramssuvidha.portal.data.repository.ProjectRepositoryImpl 
          return (T) new ProjectRepositoryImpl(singletonCImpl.projectDao(), singletonCImpl.projectUpdateDao(), singletonCImpl.provideApiServiceProvider.get());

          case 2: // com.gramssuvidha.portal.data.local.GramaSuvidhaDatabase 
          return (T) DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService 
          return (T) NetworkModule_ProvideApiServiceFactory.provideApiService(singletonCImpl.provideRetrofitProvider.get());

          case 4: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 5: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient(singletonCImpl.mockApiInterceptorProvider.get(), singletonCImpl.provideLoggingInterceptorProvider.get());

          case 6: // com.gramssuvidha.portal.data.remote.api.MockApiInterceptor 
          return (T) new MockApiInterceptor();

          case 7: // okhttp3.logging.HttpLoggingInterceptor 
          return (T) NetworkModule_ProvideLoggingInterceptorFactory.provideLoggingInterceptor();

          case 8: // com.gramssuvidha.portal.data.repository.AIRepositoryImpl 
          return (T) new AIRepositoryImpl();

          case 9: // com.gramssuvidha.portal.data.repository.FeedbackRepositoryImpl 
          return (T) new FeedbackRepositoryImpl(singletonCImpl.feedbackDao(), singletonCImpl.provideApiServiceProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
