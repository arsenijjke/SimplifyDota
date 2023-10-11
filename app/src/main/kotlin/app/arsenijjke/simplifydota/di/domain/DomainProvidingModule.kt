package app.arsenijjke.simplifydota.di.domain

import app.arsenijjke.domain.onboarding.repository.ContainerRepository
import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
import app.arsenijjke.domain.onboarding.usecase.ContainerUseCaseImpl
import app.arsenijjke.domain.onboarding.usecase.OnBoardingUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainProvidingModule {

    @Singleton
    @Provides
    fun provideOnBoardingRepository(onBoardingRepository: OnBoardingRepository): OnBoardingUseCaseImpl {
        return OnBoardingUseCaseImpl(onBoardingRepository)
    }

    @Singleton
    @Provides
    fun provideContainerRepository(containerRepository: ContainerRepository): ContainerUseCaseImpl {
        return ContainerUseCaseImpl(containerRepository)
    }
}