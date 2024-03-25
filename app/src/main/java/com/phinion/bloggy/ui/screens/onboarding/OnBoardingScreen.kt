package com.phinion.bloggy.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phinion.bloggy.R
import com.phinion.bloggy.ui.components.CustomElevatedButton
import com.phinion.bloggy.ui.components.ShowLottieAnimation
import com.phinion.bloggy.ui.theme.lightGrey

@Composable
fun OnBoardingScreen(
    onFinishedClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        ShowLottieAnimation(rawRes = R.raw.on_boarding_anim, modifier = Modifier.size(350.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.explore_the_world_of_blogs_website),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.embark_on_a_journey_of_inspiration_insight_and_exploration),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = lightGrey,
                    fontSize = 14.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(42.dp))

            CustomElevatedButton(onClick = { onFinishedClick() }, text = "Get Started")
        }

    }

}