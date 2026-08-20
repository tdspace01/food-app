package com.example.cart.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.cart.presentation.screen.CartScreen
import com.example.navigation.cart.CartRoute

fun EntryProviderScope<NavKey>.cartEntry() {
    entry<CartRoute> {
        CartScreen()
    }
}