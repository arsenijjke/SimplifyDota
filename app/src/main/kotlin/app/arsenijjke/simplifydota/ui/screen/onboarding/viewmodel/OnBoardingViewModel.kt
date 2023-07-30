package app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.navigation.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun navigateToRegistration() {
        navigator.tryNavigateTo(Destination.HomeScreen())
    }
}
