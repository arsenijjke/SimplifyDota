package app.arsenijjke.data.service.data

interface AppUsagePrefs {

    suspend fun isFirstTimeUsingApp(): Boolean?

    suspend fun saveTimeUsingApp(token: Boolean)

    suspend fun deleteTimeUsingApp()
}