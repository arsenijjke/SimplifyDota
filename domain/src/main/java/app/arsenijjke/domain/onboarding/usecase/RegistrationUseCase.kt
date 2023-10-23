package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.RegistrationRepository

fun interface RegistrationUseCase : suspend (Int) -> Unit

class RegistrationUseCaseImpl(
    private val registrationRepository: RegistrationRepository
): RegistrationUseCase {

    override suspend fun invoke(id: Int) {
        registrationRepository.saveProfileId(id)
    }
}
