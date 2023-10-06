package app.arsenijjke.simplifydota.di.data.repository

import app.arsenijjke.data.repository.onboarding.OnBoardingRepositoryImpl
import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
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
}