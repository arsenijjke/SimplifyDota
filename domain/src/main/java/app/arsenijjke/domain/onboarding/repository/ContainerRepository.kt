package app.arsenijjke.domain.onboarding.repository

fun interface ContainerRepository {
    suspend fun isFirstTimeUsingApp(): Boolean?
}