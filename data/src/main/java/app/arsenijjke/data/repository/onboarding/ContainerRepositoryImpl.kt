package app.arsenijjke.data.repository.onboarding

import app.arsenijjke.data.service.PreferenceService
import app.arsenijjke.domain.onboarding.repository.ContainerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContainerRepositoryImpl @Inject constructor(
    private val preferenceService: PreferenceService,
): ContainerRepository {

    override fun isFirstTimeUsingApp(): Flow<Boolean?> = preferenceService.isFirstTimeUsingApp()
}