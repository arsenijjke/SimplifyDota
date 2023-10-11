package app.arsenijjke.simplifydota.ui.screen.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.arsenijjke.domain.onboarding.usecase.ContainerUseCase
import app.arsenijjke.navigation.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    navigator: Navigator,
    private val containerUseCase: ContainerUseCase,
) : ViewModel() {

    val navigationChannel = navigator.navigationChannel
    var isFirstTimeUsingApp: MutableStateFlow<Boolean?> = MutableStateFlow(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            isFirstTimeUsingApp.tryEmit(containerUseCase.isFirstTimeUsingApp().first())
            Log.d("ABCD", isFirstTimeUsingApp.value.toString())
        }

    }
}
