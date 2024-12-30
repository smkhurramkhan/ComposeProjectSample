package com.example.yourtennisapp.ui.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.yourtennisapp.common.YourTennisText
import com.example.yourtennisapp.ui.home.viewmodels.TrainingViewModel
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme

@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel,
    navigateToProfile: () -> Unit
) {

    YourTennisAppTheme {
        Surface {
            Box {
                Column {
                    YourTennisText(text = "Training Screen")

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTrainingScreen(){
    TrainingScreen(hiltViewModel(),{})
}