package app.arsenijjke.simplifydota.ui.screen.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.arsenijjke.simplifydota.R
import app.arsenijjke.simplifydota.ui.screen.onboarding.state.RegistrationState

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    state: RegistrationState,
    onEvent: (String) -> Unit
) {

    var profileId by rememberSaveable { mutableStateOf(state.accountID) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = modifier
                .fillMaxWidth()
                .rotate(180f),
            painter = painterResource(id = R.drawable.wave),
            contentDescription = null,
        )

        Spacer(modifier = modifier.height(50.dp))

        Text(text = stringResource(id = R.string.before_start))

        Spacer(modifier = modifier.padding(50.dp))

        OutlinedTextField(
            value = profileId,
            onValueChange = { profileId = it },
            label = { Text(text = stringResource(id = R.string.title_text)) }
        )

        Spacer(modifier = modifier.padding(50.dp))

        StyledOutlinedButton(onClick = { onEvent(profileId) })
    }
}

@Composable
fun StyledOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: Int,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = label)) },
        singleLine = true,
        )
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen(state = RegistrationState()){}
}