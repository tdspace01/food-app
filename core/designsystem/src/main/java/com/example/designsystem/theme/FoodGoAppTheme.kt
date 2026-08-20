package com.example.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier

private val LocalFoodGoColors = staticCompositionLocalOf { LightColorScheme }
private val LocalFoodGoTypography = staticCompositionLocalOf { FoodGoTypography }

object FoodGoTheme {
    val colors: FoodGoColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalFoodGoColors.current

    val typography: FoodGoTypographyScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalFoodGoTypography.current
}

@Composable
fun FoodGoTheme(
    themeConfig: ThemeConfig = ThemeConfig.FOLLOW_SYSTEM,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeConfig) {
        ThemeConfig.FOLLOW_SYSTEM -> isSystemInDarkTheme()
        ThemeConfig.LIGHT -> false
        ThemeConfig.DARK -> true
    }

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    //SystemTheme(lightIcons = !darkTheme)
    SystemTheme()

    CompositionLocalProvider(
        LocalFoodGoColors provides colorScheme,
        LocalFoodGoTypography provides FoodGoTypography
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.bgScreen)
        ) {
            content()
        }
    }
}