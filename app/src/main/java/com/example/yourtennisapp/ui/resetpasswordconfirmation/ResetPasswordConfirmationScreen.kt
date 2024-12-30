package com.example.yourtennisapp.ui.resetpasswordconfirmation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourtennisapp.common.AddBottomLogo
import com.example.yourtennisapp.common.GradientDrawableButton
import com.example.yourtennisapp.common.ToolbarComposable
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme
import com.example.yourtennisapp.ui.theme.blueish
import com.example.yourtennisapp.utils.VerticalSpacer10dp
import com.example.yourtennisapp.utils.VerticalSpacer20dp
import com.example.yourtennisapp.utils.VerticalSpacer40dp
import com.example.yourtennisapp.utils.VerticalSpacer50dp

@Composable
fun ResetPasswordConfirmationScreen(
    onBackButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    onHelpButtonClick: () -> Unit
) {

    YourTennisAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start

                ) {
                    VerticalSpacer50dp()

                    ToolbarComposable(
                        onBackButtonClick = onBackButtonClick,
                        title = "Check je mail",
                        isMenuTextVisible = true,
                        textAlign = TextAlign.Start,
                        startPadding = 12
                    )

                    VerticalSpacer10dp()

                    Text(
                        text = "Bevestig je account met de link in de mail die je van ons hebt gekregen. Niet ontvangen? Controleer ook je spambox.",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif
                        ),
                        modifier = Modifier.padding(10.dp)
                    )

                    VerticalSpacer20dp()

                    GradientDrawableButton(
                        text = "Nu inloggen",
                        onClick = {

                        },
                    )

                    VerticalSpacer40dp()

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Hulp.",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = blueish
                            ),
                            modifier = Modifier
                                .padding(top = 16.dp, bottom = 16.dp)
                                .clickable {

                                }
                        )
                    }

                    AddBottomLogo()
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun ShowResetPasswordConfirmationScreen() {
    ResetPasswordConfirmationScreen({}, {}, {})
}