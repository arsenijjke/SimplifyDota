package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository

fun interface OnBoardingUseCase {
    suspend fun saveAppUsage(token: Boolean)
}

class OnBoardingUseCaseImpl(
    private val onBoardingRepository: OnBoardingRepository,
): OnBoardingUseCase {

    override suspend fun saveAppUsage(token: Boolean) {
        onBoardingRepository.saveAppUsage(token)
    }

}
