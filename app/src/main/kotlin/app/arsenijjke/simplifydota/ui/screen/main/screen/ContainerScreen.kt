package app.arsenijjke.simplifydota.ui.screen.main.screen

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
import app.arsenijjke.simplifydota.ui.screen.main.state.ContainerState
import app.arsenijjke.simplifydota.ui.screen.onboarding.event.NavigateToRegistrationScreenEvent
import app.arsenijjke.simplifydota.ui.screen.onboarding.screen.OnBoardingScreen
import app.arsenijjke.simplifydota.ui.screen.onboarding.screen.RegistrationScreen
import app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel.OnBoardingViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun ContainerScreen(
    containerState: ContainerState,
    startDestination: Destination
) {
    val onBoardingViewModel = hiltViewModel<OnBoardingViewModel>()
    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = containerState.navigationChannel,
        navHostController = navController
    )
    NavHost(
        navController = navController,
        startDestination = startDestination
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
