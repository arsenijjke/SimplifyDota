package app.arsenijjke.simplifydota.ui.screen.onboarding.screen

import androidx.annotation.DrawableRes
import app.arsenijjke.simplifydota.R

data class Page(
    val title: Int,
    val subtitle: Int,
    @DrawableRes val image: Int,
) {
    companion object {
        val onBoardingScreens = listOf(
            Page(
                title = R.string.welcome_screen_title,
                subtitle = R.string.welcome_screen_subtitle,
                image = R.drawable.dota_icon,
            ),
            Page(
                title = R.string.your_progress_title,
                subtitle = R.string.your_progress_subtitle,
                image = R.drawable.statistics_icon,
            ),
            Page(
                title = R.string.follow_meta_title,
                subtitle = R.string.follow_meta_subtitle,
                image = R.drawable.aegis_icon,
            ),
        )
    }
}
