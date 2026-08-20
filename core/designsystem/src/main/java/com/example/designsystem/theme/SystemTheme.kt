package com.example.designsystem.theme

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun SystemTheme(
    useDarkIcons: Boolean = true
) {
    val view = LocalView.current

    DisposableEffect(useDarkIcons) {
        val window = (view.context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val insetsController = WindowInsetsControllerCompat(window, window.decorView)

        insetsController.isAppearanceLightStatusBars = useDarkIcons
        insetsController.isAppearanceLightNavigationBars = useDarkIcons

        onDispose { }
    }
}

//val view = LocalView.current
//
//DisposableEffect(lightIcons) {
//    val window = (view.context as Activity).window
//    WindowCompat.setDecorFitsSystemWindows(window, false)
//
//    val insetsController = WindowInsetsControllerCompat(window, window.decorView)
//    insetsController.isAppearanceLightStatusBars = lightIcons
//    insetsController.isAppearanceLightNavigationBars = lightIcons
//
//    onDispose { }
//}