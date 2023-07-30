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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.arsenijjke.simplifydota.R
import app.arsenijjke.simplifydota.ui.screen.onboarding.viewmodel.OnBoardingViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: OnBoardingViewModel = hiltViewModel(),
) {

    val list = Page.onBoardingScreens
    val pagerState = rememberPagerState(0)

    val isLastPage = remember {
        derivedStateOf { pagerState.currentPage == 2 }
    }

    Column {

        Image(
            modifier = modifier
                .fillMaxWidth()
                .rotate(180f),
            painter = painterResource(id = R.drawable.wave),
            contentDescription = null,
        )

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

        AnimatedVisibility(visible = isLastPage.value ) {
            OutlinedButton(
                shape = RoundedCornerShape(15.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                onClick = { viewModel.navigateToRegistration() },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = colorResource(R.color.purple_500),
                    contentColor = Color.White)) {
                Text(text = stringResource(id = R.string.button_begin))
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
        Spacer(modifier = modifier.height(50.dp))

        Image(
            painter = painterResource(id = page.image),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(300.dp)
                .clip(CircleShape),
            contentDescription = null,
        )

        Spacer(modifier = modifier.height(60.dp))

        Text(
            modifier = modifier
                .padding(horizontal = 20.dp),
            textAlign = TextAlign.Center,
            text = stringResource(page.title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = modifier.height(10.dp))

        Text(
            modifier = modifier
                .padding(horizontal = 20.dp),
            text = stringResource(page.subtitle),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
        )
        Spacer(modifier = modifier.height(12.dp))
    }
}

@Preview
@Composable
fun WelcomePreview() {
    //WelcomeScreen()
}