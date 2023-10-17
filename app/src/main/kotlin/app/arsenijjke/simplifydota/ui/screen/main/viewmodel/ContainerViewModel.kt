package app.arsenijjke.simplifydota.ui.screen.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.arsenijjke.domain.onboarding.usecase.ContainerUseCase
import app.arsenijjke.navigation.navigator.Navigator
import app.arsenijjke.simplifydota.ui.screen.main.state.ContainerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    navigator: Navigator,
    private val containerUseCase: ContainerUseCase,
) : ViewModel() {

    var state = MutableStateFlow(
        ContainerState(
            navigationChannel = navigator.navigationChannel
        )
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            state.tryEmit(state.value.copy(isFirstTimeUsingApp = containerUseCase.isFirstTimeUsingApp()))
        }
    }
}
