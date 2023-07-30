package app.arsenijjke.simplifydota.ui.screen.main

import androidx.lifecycle.ViewModel
import app.arsenijjke.navigation.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    navigator: Navigator
) : ViewModel() {

    val navigationChannel = navigator.navigationChannel
}