package com.phinion.bloggy.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.phinion.bloggy.ui.theme.grey
import com.phinion.bloggy.ui.components.shimmerLoadingAnimation

@Composable
fun BlogItemLoading() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(grey, shape = RoundedCornerShape(12.dp))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(grey)
                .shimmerLoadingAnimation()
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey, shape = RoundedCornerShape(8.dp))
                    .shimmerLoadingAnimation()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .height(24.dp)
                    .background(grey, shape = RoundedCornerShape(8.dp))
                    .shimmerLoadingAnimation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey, shape = RoundedCornerShape(8.dp))
                    .shimmerLoadingAnimation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey, shape = RoundedCornerShape(8.dp))
                    .shimmerLoadingAnimation()
            )

        }


    }
}