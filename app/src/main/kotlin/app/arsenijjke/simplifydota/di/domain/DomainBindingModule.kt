package app.arsenijjke.simplifydota.di.domain

import app.arsenijjke.domain.onboarding.usecase.ContainerUseCase
import app.arsenijjke.domain.onboarding.usecase.ContainerUseCaseImpl
import app.arsenijjke.domain.onboarding.usecase.OnBoardingUseCase
import app.arsenijjke.domain.onboarding.usecase.OnBoardingUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindingModule {

    @Singleton
    @Binds
    fun bindOnBoardingUseCase(useCase: OnBoardingUseCaseImpl): OnBoardingUseCase

    @Singleton
    @Binds
    fun bindContainerUseCase(useCase: ContainerUseCaseImpl): ContainerUseCase
}