package app.arsenijjke.navigation.destination

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
        object OnBoardingScreen : NoArgumentsDestination(ON_BOARDING_SCREEN)

        object RegistrationScreen : NoArgumentsDestination(REGISTRATION_SCREEN)

        object ProfileScreen : NoArgumentsDestination(PROFILE_SCREEN)
    }

    companion object {
        private const val ON_BOARDING_SCREEN = "onboarding_screen"
        private const val REGISTRATION_SCREEN = "registration_screen"
        private const val PROFILE_SCREEN = "profile_screen"
    }

}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}