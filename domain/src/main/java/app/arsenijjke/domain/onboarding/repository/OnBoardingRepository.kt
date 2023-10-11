package app.arsenijjke.domain.onboarding.repository

fun interface OnBoardingRepository {
    suspend fun saveAppUsage(token: Boolean)
}
