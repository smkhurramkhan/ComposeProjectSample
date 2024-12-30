package com.example.yourtennisapp.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.yourtennisapp.MainActivity
import com.example.yourtennisapp.extensions.startActivity
import com.example.yourtennisapp.ui.login.LoginActivity
import com.example.yourtennisapp.ui.splash.screen.SplashScreen

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            this.enableEdgeToEdge()
            SplashScreen {
                this.startActivity(MainActivity::class.java, finishActivity = true)
            }
        }
    }
}