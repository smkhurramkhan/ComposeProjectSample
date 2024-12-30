package com.example.yourtennisapp.ui.forgotpassword.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.common.AddBottomLogo
import com.example.yourtennisapp.common.CustomTextField
import com.example.yourtennisapp.common.GradientDrawableButton
import com.example.yourtennisapp.common.ToolbarComposable
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme
import com.example.yourtennisapp.ui.theme.blueish
import com.example.yourtennisapp.utils.VerticalSpacer20dp
import com.example.yourtennisapp.utils.VerticalSpacer30dp
import com.example.yourtennisapp.utils.VerticalSpacer50dp

@Composable
fun ForgotPasswordScreen(
    onBackButtonClick: () -> Unit,
    nextButtonClick: () -> Unit
) {
    var email by remember { mutableStateOf(String.empty) }

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
                        title = "Wachtwoord resetten",
                        isMenuTextVisible = true
                    )

                    VerticalSpacer30dp()

                    CustomTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholderText = "E-mailadres",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    VerticalSpacer20dp()

                    GradientDrawableButton(
                        text = "Verstuur",
                        onClick = nextButtonClick
                    )

                    VerticalSpacer20dp()

                    Text(text ="We sturen je een link waarmee je jouw wachtwoord kunt resetten.",
                        style = TextStyle(
                            color = blueish,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )


                    AddBottomLogo()
                }


            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShowForgotPasswordScreen() {
    ForgotPasswordScreen({}, {})
}