package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.OnBoardingRepository

fun interface OnBoardingUseCase : suspend (Boolean) -> Unit

class OnBoardingUseCaseImpl(
    private val onBoardingRepository: OnBoardingRepository,
): OnBoardingUseCase {

    override suspend fun invoke(token: Boolean) {
        onBoardingRepository.saveAppUsage(token)
    }
}
