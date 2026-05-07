package com.gramssuvidha.portal.di;

import com.gramssuvidha.portal.data.remote.api.GramaSuvidhaApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideApiServiceFactory implements Factory<GramaSuvidhaApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GramaSuvidhaApiService get() {
    return provideApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideApiServiceFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideApiServiceFactory(retrofitProvider);
  }

  public static GramaSuvidhaApiService provideApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideApiService(retrofit));
  }
}
