package app.arsenijjke.domain.onboarding.repository

import kotlinx.coroutines.flow.Flow

fun interface ContainerRepository {
    fun isFirstTimeUsingApp(): Flow<Boolean?>
}