package app.arsenijjke.domain.onboarding.repository

fun interface RegistrationRepository {

    suspend fun saveProfileId(id: Int)
}
