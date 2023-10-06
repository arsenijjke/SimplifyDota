package app.arsenijjke.simplifydota.ui.screen.onboarding.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.arsenijjke.simplifydota.R
import app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel.RegistrationViewModel
import app.arsenijjke.simplifydota.ui.theme.components.StyledOutlinedButton

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
) {

    val viewModel: RegistrationViewModel = hiltViewModel()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.before_start))

        Spacer(modifier = modifier.padding(50.dp))

        var profileId by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = profileId,
            onValueChange = { profileId = it },
            label = { Text(text = stringResource(id = R.string.title_text)) }
        )

        Spacer(modifier = modifier.padding(50.dp))

        StyledOutlinedButton(onClick = { } )
        //onClick = { viewModel.navigateToProfile() }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}