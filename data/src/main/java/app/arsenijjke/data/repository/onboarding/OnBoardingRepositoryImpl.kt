package app.arsenijjke.data.repository.onboarding

import app.arsenijjke.data.service.PreferenceService
import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val preferencesService: PreferenceService,
) : OnBoardingRepository {
    override suspend fun saveAppUsage(token: Boolean) {
        preferencesService.saveTimeUsingApp(token)
    }
}