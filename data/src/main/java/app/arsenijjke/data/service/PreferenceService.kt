package app.arsenijjke.data.service

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import app.arsenijjke.data.service.data.AppUsagePrefs
import app.arsenijjke.data.service.data.ProfilePrefs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_preferences")

class PreferenceService(
    private val context: Context
): AppUsagePrefs, ProfilePrefs {

    companion object {
        private val FIRST_TIME_USING_APP_KEY = booleanPreferencesKey("FIRST_TIME_USING_APP")
        private val PROFILE_ID_KEY = intPreferencesKey("PROFILE_ID")
    }

    override fun isFirstTimeUsingApp(): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[FIRST_TIME_USING_APP_KEY]
        }
    }

    override suspend fun saveTimeUsingApp(token: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[FIRST_TIME_USING_APP_KEY] = token
        }
    }

    override suspend fun deleteTimeUsingApp() {
        context.dataStore.edit { preferences ->
            preferences.remove(FIRST_TIME_USING_APP_KEY)
        }
    }

    override fun getProfileId(): Flow<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun saveProfile(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProfile() {
        TODO("Not yet implemented")
    }

}
