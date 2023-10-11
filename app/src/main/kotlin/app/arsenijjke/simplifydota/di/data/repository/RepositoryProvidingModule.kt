package app.arsenijjke.simplifydota.di.data.repository

import app.arsenijjke.data.repository.onboarding.ContainerRepositoryImpl
import app.arsenijjke.data.repository.onboarding.OnBoardingRepositoryImpl
import app.arsenijjke.data.service.PreferenceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryProvidingModule {

    @Singleton
    @Provides
    fun provideOnBoardingRepository(preferenceService: PreferenceService): OnBoardingRepositoryImpl {
        return OnBoardingRepositoryImpl(preferenceService)
    }

    @Singleton
    @Provides
    fun provideContainerRepository(preferenceService: PreferenceService): ContainerRepositoryImpl {
        return ContainerRepositoryImpl(preferenceService)
    }
}