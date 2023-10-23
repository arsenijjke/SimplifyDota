package app.arsenijjke.data.service

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import app.arsenijjke.data.service.data.AppUsagePrefs
import app.arsenijjke.data.service.data.ProfilePrefs
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_preferences")

class PreferenceService(
    private val context: Context
): AppUsagePrefs, ProfilePrefs {

    companion object {
        private val FIRST_TIME_USING_APP_KEY = booleanPreferencesKey("FIRST_TIME_USING_APP")
        private val PROFILE_ID_KEY = intPreferencesKey("PROFILE_ID")
    }

    /** On-boarding Zone*/
    override suspend fun isFirstTimeUsingApp(): Boolean? {
        return context.dataStore.data.map { preferences ->
            preferences[FIRST_TIME_USING_APP_KEY]
        }.first()
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

    /** Profile zone*/
    override suspend fun getProfileId(): Int? {
        return context.dataStore.data.map { profileId ->
            profileId[PROFILE_ID_KEY]
        }.first()
    }

    override suspend fun saveProfile(id: Int) {
        context.dataStore.edit { profileId ->
            profileId[PROFILE_ID_KEY] = id
        }
    }

    override suspend fun deleteProfile() {
        context.dataStore.edit { profileId ->
            profileId.remove(PROFILE_ID_KEY)
        }
    }

}
