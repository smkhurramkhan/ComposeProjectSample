package com.example.yourtennisapp.navigation

import com.example.yourtennisapp.utils.Constants.CREATE_ACCOUNT
import com.example.yourtennisapp.utils.Constants.CREATE_PASSWORD
import com.example.yourtennisapp.utils.Constants.FORGOT_PASSWORD
import com.example.yourtennisapp.utils.Constants.LOGIN
import com.example.yourtennisapp.utils.Constants.RESET_PASSWORD_CONFIRMATION
import com.example.yourtennisapp.utils.Constants.TENNIS_SCHOOL

sealed class NavRoute(val path: String) {

    object Login : NavRoute(LOGIN)
    object CreateAccount : NavRoute(CREATE_ACCOUNT)
    object CreatePassword : NavRoute(CREATE_PASSWORD)
    object ForgotPassword : NavRoute(FORGOT_PASSWORD)
    object TennisSchool : NavRoute(TENNIS_SCHOOL)
    object ResetPasswordConfirmation : NavRoute(RESET_PASSWORD_CONFIRMATION)


}


