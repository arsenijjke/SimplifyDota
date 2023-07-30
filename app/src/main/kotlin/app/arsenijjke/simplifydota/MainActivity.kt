package app.arsenijjke.simplifydota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.arsenijjke.simplifydota.ui.screen.home.HomeScreen
import app.arsenijjke.simplifydota.ui.screen.onboarding.WelcomeScreen
import app.arsenijjke.simplifydota.ui.theme.SimplifyDotaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplifyDotaTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "onboarding_screen",
                ) {
                    composable("onboargind_screen") {
                        WelcomeScreen(Modifier) {

                        }
                    }
                    composable("home_screen") {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
