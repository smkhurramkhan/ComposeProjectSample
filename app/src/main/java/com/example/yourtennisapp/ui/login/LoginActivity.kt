package com.example.yourtennisapp.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.yourtennisapp.extensions.startActivity
import com.example.yourtennisapp.ui.createaccount.CreateAccountActivity
import com.example.yourtennisapp.ui.forgotpassword.ForgotPasswordActivity
import com.example.yourtennisapp.ui.login.screen.LoginScreen
import com.example.yourtennisapp.ui.tennisschool.ChooseTennisSchoolActivity

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            this.enableEdgeToEdge()
            LoginScreen(
                onForgotPasswordClick = {
                    this.startActivity(ForgotPasswordActivity::class.java)
                },
                onRegisterButtonClick = {
                    this.startActivity(CreateAccountActivity::class.java)
                },
                onBackButtonClick = {
                    this.finish()
                },
                onLoginButtonClick = {
                    this.startActivity(
                        ChooseTennisSchoolActivity::class.java,
                        finishActivity = true
                    )
                }
            )
        }
    }
}