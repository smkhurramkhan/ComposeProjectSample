package com.example.yourtennisapp.ui.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.yourtennisapp.ui.home.screens.ChatScreen
import com.example.yourtennisapp.utils.Constants.CHAT_NAVIGATION_ROUTE

fun NavController.navigateChat(
    navOptions: NavOptions? = null
) {
    this.navigate(CHAT_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.chatScreen() {
    composable(CHAT_NAVIGATION_ROUTE) {
        ChatScreen(
            hiltViewModel(),
            navigateToSingleChat = {
                //  navigateToDetail.invoke(it)
            }
        )
    }
}