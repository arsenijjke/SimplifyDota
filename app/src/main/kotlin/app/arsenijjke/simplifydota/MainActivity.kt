package app.arsenijjke.simplifydota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.navigation.host.NavHost
import app.arsenijjke.navigation.host.composable
import app.arsenijjke.navigation.impl.NavigationEffects
import app.arsenijjke.simplifydota.ui.screen.main.viewmodel.ContainerViewModel
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.NavigateToRegistrationScreenEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.screen.OnBoardingScreen
import app.arsenijjke.simplifydota.ui.screen.onboarding.screen.RegistrationScreen
import app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel.OnBoardingViewModel
import app.arsenijjke.simplifydota.ui.theme.SimplifyDotaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplifyDotaTheme {
                val containerViewModel = hiltViewModel<ContainerViewModel>()
                val state = containerViewModel.state.collectAsState()

                val onBoardingViewModel = hiltViewModel<OnBoardingViewModel>()
                val navController = rememberNavController()

                NavigationEffects(
                    navigationChannel = state.value.navigationChannel,
                    navHostController = navController
                )

                NavHost(
                    navController = navController,
                    startDestination =
                    if (state.value.isFirstTimeUsingApp == null) {
                        Destination.NoArgumentsDestination.OnBoardingScreen
                    } else {
                        Destination.NoArgumentsDestination.RegistrationScreen
                    }
                ) {
                    val onBoardingState = onBoardingViewModel.state

                    composable(destination = Destination.NoArgumentsDestination.OnBoardingScreen) {
                        OnBoardingScreen(
                            state = onBoardingState,
                            onEvent = { onBoardingViewModel.send(NavigateToRegistrationScreenEvent()) }
                        )
                    }

                    composable(destination = Destination.NoArgumentsDestination.RegistrationScreen) {
                        RegistrationScreen()
                    }

                }
            }
        }
    }
}


