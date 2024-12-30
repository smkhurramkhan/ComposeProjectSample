package com.example.yourtennisapp.ui.createpassword.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.common.AddBottomLogo
import com.example.yourtennisapp.common.GradientDrawableButton
import com.example.yourtennisapp.common.PasswordField
import com.example.yourtennisapp.common.ToolbarComposable
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme
import com.example.yourtennisapp.utils.VerticalSpacer20dp
import com.example.yourtennisapp.utils.VerticalSpacer40dp
import com.example.yourtennisapp.utils.VerticalSpacer50dp

@Composable
fun CreatePasswordScreen(
    onBackButtonClick: () -> Unit,
    nextButtonClick: () -> Unit
) {

    var password by remember { mutableStateOf(String.empty) }
    var confirmPassword by remember { mutableStateOf(String.empty) }


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
                        title = "Wachtwoord aanmaken",
                        isMenuTextVisible = true
                    )

                    VerticalSpacer40dp()


                    PasswordField(
                        password = password,
                        labelText = "Wachtwoord",
                        onPasswordChange = { password = it }
                    )

                    PasswordField(
                        password = confirmPassword,
                        labelText = "Wachtwoord (controle)",
                        onPasswordChange = { confirmPassword = it }
                    )

                    VerticalSpacer20dp()

                    GradientDrawableButton(
                        text = "Opslaan",
                        onClick = nextButtonClick,
                        modifier = Modifier
                    )

                    AddBottomLogo()
                }

            }
        }


    }
}

@Composable
@Preview(showBackground = true)
fun ShowCreatePasswordScreen() {
    CreatePasswordScreen({}, {})
}