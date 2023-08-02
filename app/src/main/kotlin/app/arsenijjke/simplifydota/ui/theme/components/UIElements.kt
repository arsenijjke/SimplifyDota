package app.arsenijjke.simplifydota.ui.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.arsenijjke.simplifydota.R

@Composable
fun StyledOutlinedButton(
    modifier: Modifier = Modifier,
    onClick: (Unit) -> (Unit),
) {
    OutlinedButton(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(30.dp),
        onClick = { onClick },
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = colorResource(R.color.purple_500),
            contentColor = Color.White)) {
        Text(text = stringResource(id = R.string.button_begin))
    }
}