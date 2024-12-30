package com.example.yourtennisapp.common

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.example.yourtennisapp.ui.home.navigation.navigateAccount
import com.example.yourtennisapp.ui.home.navigation.navigateChat
import com.example.yourtennisapp.ui.home.navigation.navigateTraining

@Composable
fun YourTennisBottomAppBar(
    navController: NavController,
    currentDestination: NavDestination?,
) {
    BottomAppBar(
        modifier = Modifier,
        cutoutShape = CircleShape,
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colorScheme.onPrimary
    ) {
        BottomNav.entries.forEach { screen ->
            val selected = currentDestination.isBottomNavDestinationInHierarchy(screen)
            val primaryColor = MaterialTheme.colorScheme.primary
            val secondaryColor = MaterialTheme.colorScheme.secondary

            BottomNavigationItem(
                alwaysShowLabel = true,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.secondary,
                icon = {
                     Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },

                label = {
                    YourTennisText(
                       stringResource(id = screen.titleTextId),
                        color = if (selected) primaryColor else secondaryColor,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                },
                selected = selected,
                onClick = {
                    navigateToBottomNavDestination(screen, navController)
                }
            )
        }
    }
}

fun navigateToBottomNavDestination(bottomNav: BottomNav, navController: NavController) {
    trace("Navigation: ${bottomNav.name}") {
        val bottomNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (bottomNav) {
            BottomNav.TRAINING -> navController.navigateTraining(bottomNavOptions)
            BottomNav.CHAT -> navController.navigateChat(bottomNavOptions)
            BottomNav.ACCOUNT -> navController.navigateAccount(bottomNavOptions)

        }
    }
}

private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNav) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
