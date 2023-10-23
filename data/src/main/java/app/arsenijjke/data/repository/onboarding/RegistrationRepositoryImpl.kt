package app.arsenijjke.data.repository.onboarding

import app.arsenijjke.data.service.PreferenceService
import app.arsenijjke.domain.onboarding.repository.RegistrationRepository
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val preferenceService: PreferenceService
): RegistrationRepository {

    override suspend fun saveProfileId(id: Int) {
        preferenceService.saveProfile(id)
    }
}
