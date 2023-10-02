package app.arsenijjke.data.repository.onboarding

import app.arsenijjke.data.service.PreferenceService
import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val preferencesService: PreferenceService,
): OnBoardingRepository {

    override fun isFirstTimeUsingApp(): Flow<Boolean?> {
        return preferencesService.isFirstTimeUsingApp()
    }

    override fun saveProfileId(id: Int): Flow<Unit> {
        TODO("Not yet implemented")
    }
}