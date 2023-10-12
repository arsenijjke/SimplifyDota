package app.arsenijjke.simplifydota.ui.screen.main.state

import app.arsenijjke.navigation.navigator.NavigationIntent
import kotlinx.coroutines.channels.Channel

data class ContainerState(
    var isFirstTimeUsingApp: Boolean? = true,
    val navigationChannel: Channel<NavigationIntent>
)
