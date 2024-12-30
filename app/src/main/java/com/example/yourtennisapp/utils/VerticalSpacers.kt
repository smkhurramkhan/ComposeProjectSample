package com.example.yourtennisapp.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer8dp() = VerticalSpacer(height = 8.dp)

@Composable
fun VerticalSpacer10dp() = VerticalSpacer(height = 10.dp)


@Composable
fun VerticalSpacer16dp() = VerticalSpacer(height = 16.dp)

@Composable
fun VerticalSpacer20dp() = VerticalSpacer(height = 20.dp)

@Composable
fun VerticalSpacer30dp() = VerticalSpacer(height = 30.dp)

@Composable
fun VerticalSpacer40dp() = VerticalSpacer(height = 40.dp)

@Composable
fun VerticalSpacer50dp() = VerticalSpacer(height = 50.dp)

@Composable
fun VerticalSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}