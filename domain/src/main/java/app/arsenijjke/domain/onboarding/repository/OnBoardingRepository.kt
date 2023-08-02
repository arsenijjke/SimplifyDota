package app.arsenijjke.domain.onboarding.repository

interface OnBoardingRepository {

    fun isFirstTimeUsingApp(): Boolean

    fun saveProfileId(id: Int)
}
