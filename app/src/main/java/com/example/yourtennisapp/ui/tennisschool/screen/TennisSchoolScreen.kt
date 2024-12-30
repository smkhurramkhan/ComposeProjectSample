package com.example.yourtennisapp.ui.tennisschool.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yourtennisapp.common.AddBottomLogo
import com.example.yourtennisapp.common.GradientDrawableButton
import com.example.yourtennisapp.common.ToolbarComposable
import com.example.yourtennisapp.ui.tennisschool.recomposable.SportEventsButton
import com.example.yourtennisapp.ui.tennisschool.recomposable.TennisSchoolButton
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme
import com.example.yourtennisapp.utils.VerticalSpacer20dp
import com.example.yourtennisapp.utils.VerticalSpacer30dp
import com.example.yourtennisapp.utils.VerticalSpacer50dp

@Composable
fun TennisSchoolScreen(
    onBackButtonClick: () -> Unit,
    onSportEventsButtonClick: () -> Unit,
    onTennisSchoolButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit
) {
    YourTennisAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.Start

                ) {
                    VerticalSpacer50dp()

                    ToolbarComposable(
                        onBackButtonClick = onBackButtonClick,
                        "Kies je tennisschool"
                    )

                    VerticalSpacer30dp()

                    SportEventsButton {
                        onSportEventsButtonClick()
                    }

                    VerticalSpacer20dp()

                    TennisSchoolButton {
                        onTennisSchoolButtonClick()
                    }

                    VerticalSpacer30dp()

                    GradientDrawableButton(
                        text = "Volgende",
                        onClick = {
                            onNextButtonClick()
                        }
                    )

                    AddBottomLogo()
                }


            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun TennisSchoolScreenPreview() {
    TennisSchoolScreen({}, {}, {}, {})
}