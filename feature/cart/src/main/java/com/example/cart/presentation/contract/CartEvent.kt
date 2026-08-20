package com.example.cart.presentation.contract

sealed interface CartEvent {
    data class OnIncrementQuantity(val itemId: Int, val currentQty: Int) : CartEvent
    data class OnDecrementQuantity(val itemId: Int, val currentQty: Int) : CartEvent
    data object OnCheckoutClicked : CartEvent
    data object OnResetSuccess : CartEvent
}