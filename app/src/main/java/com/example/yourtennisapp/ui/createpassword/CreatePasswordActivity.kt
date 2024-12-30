package com.example.yourtennisapp.ui.createpassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.yourtennisapp.ui.createaccount.screen.CreateAccountScreen
import com.example.yourtennisapp.ui.createpassword.screen.CreatePasswordScreen
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme

class CreatePasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            YourTennisAppTheme {

                CreatePasswordScreen(
                    onBackButtonClick = {finish()},
                    nextButtonClick = {

                    }
                )
            }


        }
    }
}