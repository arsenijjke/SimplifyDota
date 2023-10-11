package app.arsenijjke.simplifydota.ui.screen.onboarding.state

import androidx.compose.runtime.Immutable
import app.arsenijjke.simplifydota.ui.screen.onboarding.screen.Page

@Immutable
data class OnBoardingState(
    val pages: List<Page> = Page.onBoardingScreens,
    val initialPage: Int = 0
)
