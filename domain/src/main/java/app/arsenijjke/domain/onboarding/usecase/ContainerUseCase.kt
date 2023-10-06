package app.arsenijjke.domain.onboarding.usecase

import app.arsenijjke.domain.onboarding.repository.ContainerRepository
import kotlinx.coroutines.flow.Flow

interface ContainerUseCase {
    fun isFirstTimeUsingApp(): Flow<Boolean?>
}

class ContainerUseCaseImpl(
    private val containerRepository: ContainerRepository,
) : ContainerUseCase {

    override fun isFirstTimeUsingApp(): Flow<Boolean?> =
        containerRepository.isFirstTimeUsingApp()

}