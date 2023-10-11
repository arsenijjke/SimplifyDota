package app.arsenijjke.simplifydota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.simplifydota.ui.screen.main.screen.MainScreen
import app.arsenijjke.simplifydota.ui.screen.main.viewmodel.ContainerViewModel
import app.arsenijjke.simplifydota.ui.theme.SimplifyDotaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplifyDotaTheme {
                val startDestination: Destination.NoArgumentsDestination

                val containerViewModel = hiltViewModel<ContainerViewModel>()
                startDestination = if (containerViewModel.isFirstTimeUsingApp.collectAsState().value == null) {
                    Destination.NoArgumentsDestination.OnBoardingScreen
                } else {
                    Destination.NoArgumentsDestination.RegistrationScreen
                }
                MainScreen(
                    containerViewModel,
                    startDestination
                )
            }
        }
    }
}
