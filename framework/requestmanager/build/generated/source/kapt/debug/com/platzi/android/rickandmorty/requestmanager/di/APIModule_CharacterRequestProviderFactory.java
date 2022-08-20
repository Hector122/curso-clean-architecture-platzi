// Generated by Dagger (https://dagger.dev).
package com.platzi.android.rickandmorty.requestmanager.di;

import com.platzi.android.rickandmorty.requestmanager.CharacterRequest;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class APIModule_CharacterRequestProviderFactory implements Factory<CharacterRequest> {
  private final APIModule module;

  private final Provider<String> baseUrlProvider;

  public APIModule_CharacterRequestProviderFactory(APIModule module,
      Provider<String> baseUrlProvider) {
    this.module = module;
    this.baseUrlProvider = baseUrlProvider;
  }

  @Override
  public CharacterRequest get() {
    return characterRequestProvider(module, baseUrlProvider.get());
  }

  public static APIModule_CharacterRequestProviderFactory create(APIModule module,
      Provider<String> baseUrlProvider) {
    return new APIModule_CharacterRequestProviderFactory(module, baseUrlProvider);
  }

  public static CharacterRequest characterRequestProvider(APIModule instance, String baseUrl) {
    return Preconditions.checkNotNull(instance.characterRequestProvider(baseUrl), "Cannot return null from a non-@Nullable @Provides method");
  }
}
