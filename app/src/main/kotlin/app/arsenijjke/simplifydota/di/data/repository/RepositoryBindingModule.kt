package app.arsenijjke.simplifydota.di.data.repository

import app.arsenijjke.data.repository.onboarding.ContainerRepositoryImpl
import app.arsenijjke.data.repository.onboarding.OnBoardingRepositoryImpl
import app.arsenijjke.data.repository.onboarding.RegistrationRepositoryImpl
import app.arsenijjke.domain.onboarding.repository.ContainerRepository
import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
import app.arsenijjke.domain.onboarding.repository.RegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryBindingModule {

    @Singleton
    @Binds
    fun bindOnBoardingRepository(onBoardingRepository: OnBoardingRepositoryImpl): OnBoardingRepository

    @Singleton
    @Binds
    fun bindRegistrationRepository(registrationRepository: RegistrationRepositoryImpl): RegistrationRepository

    @Singleton
    @Binds
    fun bindContainerRepository(containerRepositoryImpl: ContainerRepositoryImpl): ContainerRepository
}
