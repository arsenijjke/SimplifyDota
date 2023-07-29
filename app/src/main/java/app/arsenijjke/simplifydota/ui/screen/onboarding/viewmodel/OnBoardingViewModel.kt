package app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class OnBoardingViewModel(
    private val navController: NavHostController,
): ViewModel() {

    fun navigateToRegistration() {
        navController.navigate("home_screen")
    }
}