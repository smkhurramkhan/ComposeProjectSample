package com.example.yourtennisapp.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.R

@Composable
fun AddBottomLogo() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.logo_black_and_white),
                contentDescription = String.empty,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowBottomLogo(){
    AddBottomLogo()
}