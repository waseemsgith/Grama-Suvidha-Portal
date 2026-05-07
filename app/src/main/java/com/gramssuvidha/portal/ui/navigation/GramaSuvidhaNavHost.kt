package com.gramssuvidha.portal.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gramssuvidha.portal.ui.details.DetailsScreen
import com.gramssuvidha.portal.ui.feedback.FeedbackScreen
import com.gramssuvidha.portal.ui.home.HomeScreen
import com.gramssuvidha.portal.ui.settings.SettingsScreen

/**
 * Main navigation host with animated transitions.
 */
@Composable
fun GramaSuvidhaNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it / 3 },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it / 3 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onProjectClick = { projectId ->
                    navController.navigate(Screen.Details.createRoute(projectId))
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("projectId") { type = NavType.StringType })
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getString("projectId") ?: ""
            DetailsScreen(
                projectId = projectId,
                onBack = { navController.popBackStack() },
                onFeedbackClick = { id, title ->
                    navController.navigate(Screen.Feedback.createRoute(id, title))
                }
            )
        }

        composable(
            route = Screen.Feedback.route,
            arguments = listOf(
                navArgument("projectId") { type = NavType.StringType },
                navArgument("projectTitle") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getString("projectId") ?: ""
            val projectTitle = backStackEntry.arguments?.getString("projectTitle")
                ?.replace("|", "/") ?: ""
            FeedbackScreen(
                projectId = projectId,
                projectTitle = projectTitle,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
