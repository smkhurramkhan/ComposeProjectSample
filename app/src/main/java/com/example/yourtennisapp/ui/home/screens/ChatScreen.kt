package com.example.yourtennisapp.ui.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.yourtennisapp.common.YourTennisText
import com.example.yourtennisapp.ui.home.viewmodels.TrainingViewModel
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme

@Composable
fun ChatScreen(
    viewModel: TrainingViewModel,
    navigateToSingleChat: () -> Unit
) {


    YourTennisAppTheme {
        Surface(Modifier.fillMaxSize()) {
            Box() {
                Column {
                    YourTennisText(
                        text = "Chat Screen",
                        modifier = Modifier.offset(x=20.dp
                            , y=50.dp)
                    )

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShowChatScreen() {
    ChatScreen(hiltViewModel(), {})
}