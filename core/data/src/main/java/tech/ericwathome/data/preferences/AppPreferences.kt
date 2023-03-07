package tech.ericwathome.data.preferences

import kotlinx.coroutines.flow.Flow

interface AppPreferences {
    fun showOnBoarding(): Flow<Boolean>
    suspend fun updateOnboardingStatus(showOnboarding: Boolean)
}