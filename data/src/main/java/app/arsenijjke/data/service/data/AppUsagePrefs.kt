package app.arsenijjke.data.service.data

import kotlinx.coroutines.flow.Flow

interface AppUsagePrefs {

    fun isFirstTimeUsingApp(): Flow<Boolean?>

    suspend fun saveTimeUsingApp(token: Boolean)

    suspend fun deleteTimeUsingApp()
}