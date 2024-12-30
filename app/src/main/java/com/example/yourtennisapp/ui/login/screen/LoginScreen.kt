package com.example.yourtennisapp.ui.login.screen

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.common.AddBottomLogo
import com.example.yourtennisapp.common.CustomTextField
import com.example.yourtennisapp.common.GradientDrawableButton
import com.example.yourtennisapp.common.SignUpPrompt
import com.example.yourtennisapp.common.ToolbarComposable
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme
import com.example.yourtennisapp.ui.theme.blueish
import com.example.yourtennisapp.utils.VerticalSpacer10dp
import com.example.yourtennisapp.utils.VerticalSpacer20dp
import com.example.yourtennisapp.utils.VerticalSpacer50dp

@Composable
fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onRegisterButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    onLoginButtonClick: () -> Unit
) {

    var email by remember { mutableStateOf(String.empty) }
    var password by remember { mutableStateOf(String.empty) }

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
                        title = "Inloggen"
                    )

                    VerticalSpacer10dp()

                    CustomTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholderText = "E-mailadres",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    VerticalSpacer10dp()

                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholderText = "Wachtwoord",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        isPasswordField = true
                    )

                    VerticalSpacer50dp()

                    GradientDrawableButton(
                        text = "Inloggen",
                        onClick = {
                            onLoginButtonClick()
                        },
                        modifier = Modifier
                    )

                    VerticalSpacer20dp()

                    SignUpPrompt(onSignUpClick = {
                        onRegisterButtonClick()
                    })

                    VerticalSpacer20dp()

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Wachtwoord vergeten?",
                            style = TextStyle(
                                textAlign = TextAlign.Center,
                                color = blueish,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = Modifier.clickable {
                                onForgotPasswordClick()
                            }
                        )
                    }

                    AddBottomLogo()
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen({}, {}, {}, {})
}