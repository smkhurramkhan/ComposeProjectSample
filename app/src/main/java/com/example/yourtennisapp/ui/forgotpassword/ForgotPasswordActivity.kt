package com.example.yourtennisapp.ui.forgotpassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.yourtennisapp.ui.forgotpassword.screen.ForgotPasswordScreen
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            YourTennisAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    ForgotPasswordScreen(
                        onBackButtonClick = {
                            finish()
                        },
                        nextButtonClick = {

                        }
                    )
                }
            }

        }
    }
}