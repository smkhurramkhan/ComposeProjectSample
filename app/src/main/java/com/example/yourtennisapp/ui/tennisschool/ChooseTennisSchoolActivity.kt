package com.example.yourtennisapp.ui.tennisschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.yourtennisapp.ui.tennisschool.screen.TennisSchoolScreen

class ChooseTennisSchoolActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            this.enableEdgeToEdge()
            TennisSchoolScreen(
                onBackButtonClick = {
                    this.finish()
                },
                onSportEventsButtonClick = {

                },
                onTennisSchoolButtonClick = {

                },
                onNextButtonClick = {

                }
            )
        }
    }
}