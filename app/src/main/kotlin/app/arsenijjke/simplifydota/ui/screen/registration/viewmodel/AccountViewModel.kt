package app.arsenijjke.simplifydota.ui.screen.registration.viewmodel

import androidx.lifecycle.ViewModel
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.navigation.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor (
    private val navigator: Navigator,
    // private val registrationRepository: RegistrationRepository,
): ViewModel() {

    fun navigateToProfile() {
        navigator.tryNavigateTo(Destination.ProfileScreen())
    }
}
