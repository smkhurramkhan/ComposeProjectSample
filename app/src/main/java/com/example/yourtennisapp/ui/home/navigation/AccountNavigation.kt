package com.example.yourtennisapp.ui.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.yourtennisapp.ui.home.screens.AccountScreen
import com.example.yourtennisapp.utils.Constants.ACCOUNT_NAVIGATION_ROUTE

fun NavController.navigateAccount(
    navOptions: NavOptions? = null
) {
    this.navigate(ACCOUNT_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.accountScreen() {
    composable(ACCOUNT_NAVIGATION_ROUTE) {
        AccountScreen(
            hiltViewModel(),
            navigateToSettings = {
                //  navigateToDetail.invoke(it)
            }
        )
    }
}