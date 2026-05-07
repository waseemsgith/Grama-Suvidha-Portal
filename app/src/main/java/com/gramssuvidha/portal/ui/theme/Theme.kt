package com.gramssuvidha.portal.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary            = GreenPrimary,
    onPrimary          = NeutralSurface,
    primaryContainer   = GreenContainer,
    onPrimaryContainer = GreenPrimaryDark,
    secondary          = SaffronAccent,
    onSecondary        = NeutralSurface,
    secondaryContainer = SaffronContainer,
    onSecondaryContainer = EarthBrown,
    tertiary           = SkyBlue,
    onTertiary         = NeutralSurface,
    tertiaryContainer  = SkyContainer,
    background         = NeutralBackground,
    onBackground       = NeutralOnSurface,
    surface            = NeutralSurface,
    onSurface          = NeutralOnSurface,
    surfaceVariant     = NeutralDivider,
    onSurfaceVariant   = NeutralSubtext,
    outline            = NeutralSubtext,
    error              = StatusDelayed
)

private val DarkColorScheme = darkColorScheme(
    primary            = GreenLight,
    onPrimary          = GreenPrimaryDark,
    primaryContainer   = GreenPrimaryDark,
    onPrimaryContainer = GreenContainer,
    secondary          = SaffronLight,
    onSecondary        = EarthBrown,
    secondaryContainer = EarthBrown,
    onSecondaryContainer = SaffronContainer,
    tertiary           = SkyBlueLight,
    onTertiary         = SkyBlue,
    background         = DarkBackground,
    onBackground       = DarkOnSurface,
    surface            = DarkSurface,
    onSurface          = DarkOnSurface,
    surfaceVariant     = DarkSurfaceVariant,
    onSurfaceVariant   = NeutralDivider,
    outline            = NeutralSubtext,
    error              = Color(0xFFEF9A9A)
)

@Composable
fun GramaSuvidhaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Disabled by default to keep brand identity
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

// Error color used in dark scheme (defined inline above)
