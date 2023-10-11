package app.arsenijjke.simplifydota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.arsenijjke.simplifydota.ui.screen.main.screen.MainScreen
import app.arsenijjke.simplifydota.ui.theme.SimplifyDotaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplifyDotaTheme {
                MainScreen()
            }
        }
    }
}
