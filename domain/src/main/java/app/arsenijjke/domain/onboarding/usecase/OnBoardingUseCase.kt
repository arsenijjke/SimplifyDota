package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow

interface OnBoardingUseCase {
    fun isFirstTimeUsingApp(): Flow<Boolean?>

    fun saveProfileId(id: Int): Flow<Unit>
}

class OnBoardingUseCaseImpl(
    private val onBoardingRepository: OnBoardingRepository,
): OnBoardingUseCase {

    override fun isFirstTimeUsingApp(): Flow<Boolean?> =
        onBoardingRepository.isFirstTimeUsingApp()

    override fun saveProfileId(id: Int): Flow<Unit> =
        onBoardingRepository.saveProfileId(id)

}
