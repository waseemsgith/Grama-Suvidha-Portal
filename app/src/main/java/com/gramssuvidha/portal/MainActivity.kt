package com.gramssuvidha.portal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gramssuvidha.portal.ui.navigation.GramaSuvidhaNavHost
import com.gramssuvidha.portal.ui.theme.GramaSuvidhaTheme
import com.gramssuvidha.portal.utils.LanguageUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Main entry point of the application.
 * Handles splash screen, theme, and navigation setup.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var languageUtils: LanguageUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val isDarkMode by languageUtils.isDarkMode.collectAsState(initial = isSystemInDarkTheme())

            GramaSuvidhaTheme(darkTheme = isDarkMode) {
                GramaSuvidhaNavHost()
            }
        }
    }
}
