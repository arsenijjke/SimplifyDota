package app.arsenijjke.simplifydota.ui.screen.main

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.arsenijjke.navigation.destination.Destination
import app.arsenijjke.navigation.host.NavHost
import app.arsenijjke.navigation.host.composable
import app.arsenijjke.navigation.navigator.NavigationIntent
import app.arsenijjke.simplifydota.ui.screen.onboarding.WelcomeScreen
import app.arsenijjke.simplifydota.ui.screen.registration.RegistrationScreen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun MainScreen(
    containerViewModel: ContainerViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = containerViewModel.navigationChannel,
        navHostController = navController
    )
    NavHost(
        navController = navController,
        startDestination = Destination.OnBoardingScreen
    ) {
        composable(destination = Destination.OnBoardingScreen) {
            WelcomeScreen()
        }
        composable(destination = Destination.AccountScreen) {
            RegistrationScreen()
        }

    }
}


@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route!!, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}