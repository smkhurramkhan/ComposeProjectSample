package com.example.yourtennisapp.navigation

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.yourtennisapp.common.BottomNav
import com.example.yourtennisapp.common.YourTennisBottomAppBar
import com.example.yourtennisapp.common.YourTennisScaffold
import com.example.yourtennisapp.extensions.startActivity
import com.example.yourtennisapp.ui.createaccount.screen.CreateAccountScreen
import com.example.yourtennisapp.ui.createpassword.screen.CreatePasswordScreen
import com.example.yourtennisapp.ui.forgotpassword.screen.ForgotPasswordScreen
import com.example.yourtennisapp.ui.home.HomeActivity
import com.example.yourtennisapp.ui.home.navigation.accountScreen
import com.example.yourtennisapp.ui.home.navigation.chatScreen
import com.example.yourtennisapp.ui.home.navigation.trainingScreen
import com.example.yourtennisapp.ui.login.screen.LoginScreen
import com.example.yourtennisapp.ui.resetpasswordconfirmation.ResetPasswordConfirmationScreen
import com.example.yourtennisapp.ui.tennisschool.screen.TennisSchoolScreen
import com.example.yourtennisapp.utils.Constants
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(navController: NavHostController, activity: Activity) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Login.path
    ) {
        addLoginScreen(navController, activity)
        addCreateAccountScreen(navController)
        addCreatePasswordScreen(navController)
        addForgotPasswordScreen(navController)
        addTennisSchoolScreen(navController)
        addResetPasswordConfirmationScreen(navController)


    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination

    YourTennisScaffold(
        bottomBar = {
            BottomNav.entries.forEach { navItem ->
                if (navItem.route == currentRoute) {
                    YourTennisBottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.onPrimary,
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = Constants.TRAINING_NAVIGATION_ROUTE,
            Modifier.padding(innerPadding)
        ) {
            trainingScreen()
            chatScreen()
            accountScreen()
        }
    }
}


private fun NavGraphBuilder.addResetPasswordConfirmationScreen(navController: NavHostController) {
    this.composable(route = NavRoute.ResetPasswordConfirmation.path) {

        ResetPasswordConfirmationScreen(
            onBackButtonClick = {
                navController.popBackStack()
            },
            onNextButtonClick = {

            },
            onHelpButtonClick = {

            }
        )
    }
}

private fun NavGraphBuilder.addTennisSchoolScreen(navController: NavHostController) {
    this.composable(route = NavRoute.TennisSchool.path) {

        TennisSchoolScreen(
            onBackButtonClick = {
                navController.popBackStack()
            },
            onSportEventsButtonClick = {},
            onTennisSchoolButtonClick = {},
            onNextButtonClick = {
                navController.navigate(NavRoute.CreateAccount.path)
            },

            )
    }
}

private fun NavGraphBuilder.addForgotPasswordScreen(navController: NavHostController) {
    this.composable(route = NavRoute.ForgotPassword.path) {

        ForgotPasswordScreen(
            onBackButtonClick = {
                navController.popBackStack()
            },
            nextButtonClick = {
                navController.navigate(NavRoute.ResetPasswordConfirmation.path)
            },

            )
    }
}

private fun NavGraphBuilder.addCreatePasswordScreen(
    navController: NavHostController
) {
    this.composable(route = NavRoute.CreatePassword.path) {

        CreatePasswordScreen(
            onBackButtonClick = {
                navController.popBackStack()
            },
            nextButtonClick = {

            },

            )
    }
}

private fun NavGraphBuilder.addLoginScreen(
    navController: NavHostController,
    activity: Activity
) {
    this.composable(route = NavRoute.Login.path) {
        LoginScreen(
            onBackButtonClick = {
                activity.finish()
            },
            onLoginButtonClick = {
                //navController.navigate(NavRoute.TennisSchool.path)
               activity.startActivity(HomeActivity::class.java, finishActivity = true)
            },
            onForgotPasswordClick = {
                navController.navigate(NavRoute.ForgotPassword.path)
            },
            onRegisterButtonClick = {
                navController.navigate(NavRoute.CreateAccount.path)
            }
        )
    }
}

private fun NavGraphBuilder.addCreateAccountScreen(
    navController: NavHostController
) {
    this.composable(route = NavRoute.CreateAccount.path) {

        CreateAccountScreen(
            onBackButtonClick = {
                navController.popBackStack()
            },
            nextButtonClick = {
                navController.navigate(NavRoute.CreatePassword.path)
            },

            )
    }
}

private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(NavRoute.Login.path, inclusive = false)
}

/*private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.withArgsFormat(NavRoute.Profile.id, NavRoute.Profile.showDetails),
        arguments = listOf(
            navArgument(NavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(NavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        ProfileScreen(
            id = args?.getInt(NavRoute.Profile.id)!!,
            showDetails = args.getBoolean(NavRoute.Profile.showDetails),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}

private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Search.withArgsFormat(NavRoute.Search.query),
        arguments = listOf(
            navArgument(NavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        SearchScreen(
            query = args?.getString(NavRoute.Search.query),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}*/
