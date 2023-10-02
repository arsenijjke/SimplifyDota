package app.arsenijjke.domain.onboarding.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {

    fun isFirstTimeUsingApp(): Flow<Boolean?>

    fun saveProfileId(id: Int): Flow<Unit>
}
