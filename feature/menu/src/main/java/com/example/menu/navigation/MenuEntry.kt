package com.example.menu.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.menu.presentation.screen.MenuScreen
import com.example.navigation.menu.MenuRoute

fun EntryProviderScope<NavKey>.menuEntry() {
    entry<MenuRoute> {
        MenuScreen()
    }
}