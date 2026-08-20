package com.example.cart.presentation.contract

import com.example.domain.model.CartItem

data class CartState(
    val cartItems: List<CartItem> = emptyList(),
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false
) {
    val totalPrice: Double
        get() = cartItems.sumOf { it.price * it.quantity }

    val isEmpty: Boolean
        get() = cartItems.isEmpty()
}