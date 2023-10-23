package app.arsenijjke.data.service.data

interface ProfilePrefs {

    suspend fun getProfileId(): Int?

    suspend fun saveProfile(id: Int)

    suspend fun deleteProfile()
}