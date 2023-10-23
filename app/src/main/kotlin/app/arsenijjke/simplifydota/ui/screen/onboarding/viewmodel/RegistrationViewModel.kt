package app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.arsenijjke.domain.onboarding.usecase.RegistrationUseCase
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.navigation.navigator.Navigator
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.NavigateToProfileEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.RegistrationEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.SaveAccountIdEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.state.RegistrationState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val navigator: Navigator,
    private val registrationUseCase: RegistrationUseCase,
): ViewModel() {

    var state by mutableStateOf(RegistrationState())
        private set

    fun send(event: RegistrationEvent) {
        when(event) {
            is SaveAccountIdEvent -> {
                navigateToProfileScreen()
            }
            is NavigateToProfileEvent -> {

            }
        }
    }

    private fun save(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            registrationUseCase(id.toInt())
        }
    }

    private fun navigateToProfileScreen() {
        navigator.tryNavigateTo(Destination.NoArgumentsDestination.RegistrationScreen())
    }
}