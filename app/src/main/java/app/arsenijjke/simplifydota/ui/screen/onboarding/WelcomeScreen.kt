@file:OptIn(ExperimentalPagerApi::class)

package app.arsenijjke.simplifydota.ui.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.arsenijjke.simplifydota.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onGettingStartedClick: () -> Unit
) {
    val list = Page.onBoardingScreens
    val pagerState = rememberPagerState(0)
    Column {

        HorizontalPager(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),
            state = pagerState,
            count = list.size,
        ) { page ->
            OnBoardingPageUI(page = list[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = colorResource(R.color.purple_500)
        )

        AnimatedVisibility(visible = pagerState.currentPage == 2 ) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp
                    ),
                onClick = onGettingStartedClick,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = colorResource(R.color.purple_500),
                    contentColor = Color.White)) {
                Text(text = "fdmskfmdsk")
            }
        }
    }
}

@Composable
fun OnBoardingPageUI(
    page: Page,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = page.image),
            modifier = modifier.size(400.dp),
            contentDescription = null,
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(
            text = stringResource(page.title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = modifier.height(8.dp))

        Text(
            text = stringResource(page.title),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
        )
        Spacer(modifier = modifier.height(12.dp))
    }
}

@Preview
@Composable
fun WelcomePreview() {
    //WelcomeScreen()
}