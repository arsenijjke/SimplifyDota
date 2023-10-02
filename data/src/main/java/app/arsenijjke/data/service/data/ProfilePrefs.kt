package app.arsenijjke.data.service.data

import kotlinx.coroutines.flow.Flow

interface ProfilePrefs {

    fun getProfileId(): Flow<Int>

    suspend fun saveProfile(id: Int)

    suspend fun deleteProfile()
}