package com.example.yourtennisapp.ui.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.yourtennisapp.ui.home.screens.TrainingScreen
import com.example.yourtennisapp.utils.Constants.TRAINING_NAVIGATION_ROUTE

/**
 * Created by mertcantoptas on 23.01.2023
 */


fun NavController.navigateTraining(
    navOptions: NavOptions? = null
) {
    this.navigate(TRAINING_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.trainingScreen() {
    composable(TRAINING_NAVIGATION_ROUTE) {
        TrainingScreen(
            hiltViewModel(),
            navigateToProfile = {
                //  navigateToDetail.invoke(it)
            }
        )
    }
}