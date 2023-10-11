package app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.arsenijjke.data.service.PreferenceService
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.navigation.navigator.Navigator
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.NavigateToRegistrationScreenEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.OnBoardingEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.SaveAppUsageEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.state.OnBoardingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val navigator: Navigator,
    private val preferenceService: PreferenceService,
): ViewModel() {

    var state by mutableStateOf(OnBoardingState())
        private set

    fun send(event: OnBoardingEvent) {
        when(event) {
            is SaveAppUsageEvent -> {
                save()
            }
            is NavigateToRegistrationScreenEvent -> {
                navigateToRegistration()
            }
        }
    }

    private fun save() {
        viewModelScope.launch(Dispatchers.IO) {
            preferenceService.saveTimeUsingApp(true)
        }
    }

    private fun navigateToRegistration() {
        navigator.tryNavigateTo(Destination.RegistrationScreen())
    }

}
