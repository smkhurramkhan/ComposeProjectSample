package com.example.yourtennisapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.yourtennisapp.navigation.NavGraph
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(this)
        }
    }
}

@Composable
private fun MainScreen(activity: Activity) {
    YourTennisAppTheme {
        val navController = rememberNavController()
        NavGraph(navController,activity)
    }
}
