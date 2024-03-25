package com.phinion.bloggy.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.phinion.bloggy.R
import com.phinion.bloggy.ui.theme.SPLASH_ICON_SIZE
import com.phinion.bloggy.utils.Constants
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashComplete: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LaunchedEffect(key1 = Unit) {
            delay(Constants.SPLASH_DELAY)
            onSplashComplete()
        }

        Image(
            modifier = Modifier.size(SPLASH_ICON_SIZE),
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = "App Icon"
        )

    }

}