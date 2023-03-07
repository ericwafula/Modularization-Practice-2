package tech.ericwathome.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import tech.ericwathome.data.util.PreferenceConstants
import java.io.IOException

private val Context.datastore by preferencesDataStore(name = PreferenceConstants.APP_PREFERENCES)
class AppPreferencesImpl(private val context: Context) : AppPreferences {

    companion object {
        private val SHOW_ONBOARDING_KEY = booleanPreferencesKey(PreferenceConstants.SHOW_ONBOARDING_PREFERENCE_KEY)
    }

    override fun showOnBoarding(): Flow<Boolean> {
        return context.datastore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            }
        }.map { preferences ->
            preferences[SHOW_ONBOARDING_KEY] ?: false
        }
    }

    override suspend fun updateOnboardingStatus(showOnboarding: Boolean) {
        context.datastore.edit { preferences ->
            preferences[SHOW_ONBOARDING_KEY] = showOnboarding
        }
    }
}