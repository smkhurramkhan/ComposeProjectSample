package com.example.yourtennisapp.ui.createaccount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.yourtennisapp.extensions.startActivity
import com.example.yourtennisapp.ui.createaccount.screen.CreateAccountScreen
import com.example.yourtennisapp.ui.createpassword.CreatePasswordActivity
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme

class CreateAccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YourTennisAppTheme {
                CreateAccountScreen(
                    onBackButtonClick = {
                        finish()
                    },
                    nextButtonClick = {
                        this.startActivity(CreatePasswordActivity::class.java)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YourTennisAppTheme {
        CreateAccountScreen({}, {})
    }
}