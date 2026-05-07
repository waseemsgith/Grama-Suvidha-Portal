package com.gramssuvidha.portal.ui.navigation

/**
 * Sealed class defining all navigation routes in the app.
 */
sealed class Screen(val route: String) {
    object Home     : Screen("home")
    object Details  : Screen("details/{projectId}") {
        fun createRoute(projectId: String) = "details/$projectId"
    }
    object Feedback : Screen("feedback/{projectId}/{projectTitle}") {
        fun createRoute(projectId: String, projectTitle: String) =
            "feedback/$projectId/${projectTitle.replace("/", "|")}"
    }
    object Settings : Screen("settings")
}
