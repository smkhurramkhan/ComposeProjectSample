package com.example.yourtennisapp.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.yourtennisapp.R
import com.example.yourtennisapp.utils.Constants.CHAT_NAVIGATION_ROUTE
import com.example.yourtennisapp.utils.Constants.ACCOUNT_NAVIGATION_ROUTE
import com.example.yourtennisapp.utils.Constants.TRAINING_NAVIGATION_ROUTE


enum class BottomNav(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    TRAINING(
        TRAINING_NAVIGATION_ROUTE,
        R.drawable.ic_training,
        R.string.training,
    ),
    CHAT(
        CHAT_NAVIGATION_ROUTE,
        R.drawable.ic_chat,
        R.string.chat
    ),
    ACCOUNT(
        ACCOUNT_NAVIGATION_ROUTE,
        R.drawable.ic_account,
        R.string.account,
    )
}