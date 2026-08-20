package com.example.menu.presentation.contract

import com.example.domain.model.CartItem
import com.example.domain.model.FoodFilter

data class MenuState(
    val selectedFilter: FoodFilter = FoodFilter.ALL,
    val menuItems: List<CartItem> = emptyList(),
    val cartItems: List<CartItem> = emptyList(),
    val isLoading: Boolean = false
) {
    val totalCartCount: Int
        get() = cartItems.sumOf { it.quantity }

    fun getQuantityFor(itemId: Int): Int {
        return cartItems.find { it.id == itemId }?.quantity ?: 0
    }
}
