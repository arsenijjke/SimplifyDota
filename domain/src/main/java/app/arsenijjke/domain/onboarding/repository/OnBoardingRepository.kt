package app.arsenijjke.domain.onboarding.repository

import kotlinx.coroutines.flow.Flow

fun interface OnBoardingRepository {
    fun saveProfileId(id: Int): Flow<Unit>
}
