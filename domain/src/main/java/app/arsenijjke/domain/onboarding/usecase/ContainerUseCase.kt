package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.ContainerRepository

interface ContainerUseCase {
    suspend fun isFirstTimeUsingApp(): Boolean?
}

class ContainerUseCaseImpl(
    private val containerRepository: ContainerRepository,
) : ContainerUseCase {

    override suspend fun isFirstTimeUsingApp(): Boolean? =
        containerRepository.isFirstTimeUsingApp()

}