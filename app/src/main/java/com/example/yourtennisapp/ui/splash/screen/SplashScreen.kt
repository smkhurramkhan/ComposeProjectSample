package com.example.yourtennisapp.ui.splash.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(targetValue = if (isVisible) 1f else 0f)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.splash_bg),
                    contentScale = ContentScale.FillBounds
                )
                .padding(innerPadding)
                .alpha(alphaAnimation.value),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(R.drawable.splashlogo),
                contentDescription = String.empty,
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
            )

            LaunchedEffect(Unit) {
                isVisible = true
                delay(3000)
                onTimeout()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(onTimeout = {})
}