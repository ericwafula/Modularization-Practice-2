package tech.ericwathome.modularizationpractice2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tech.ericwathome.data.preferences.AppPreferences
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val preferences: AppPreferences
) : ViewModel() {
    private var _onboardingStatus = mutableStateOf(false)
    val onboardingStatus: State<Boolean> = _onboardingStatus

    init {
        getOnboardingStatus()
    }

    fun updateOnboardingStatus(showOnboarding: Boolean) {
        viewModelScope.launch {
            preferences.updateOnboardingStatus(showOnboarding)
        }
        getOnboardingStatus()
    }

    private fun getOnboardingStatus() {
        viewModelScope.launch {
            preferences.showOnBoarding().collect {
                _onboardingStatus.value = it
            }
        }
    }

}