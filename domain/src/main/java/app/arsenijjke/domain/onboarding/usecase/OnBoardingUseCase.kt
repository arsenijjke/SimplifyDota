package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow

interface OnBoardingUseCase {
    fun saveProfileId(id: Int): Flow<Unit>
}

class OnBoardingUseCaseImpl(
    private val onBoardingRepository: OnBoardingRepository,
): OnBoardingUseCase {

    override fun saveProfileId(id: Int): Flow<Unit> =
        onBoardingRepository.saveProfileId(id)

}
