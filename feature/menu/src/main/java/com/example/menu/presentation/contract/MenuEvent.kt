package com.example.menu.presentation.contract

import com.example.domain.model.CartItem
import com.example.domain.model.FoodFilter

sealed interface MenuEvent {
    data class OnFilterSelected(val filter: FoodFilter) : MenuEvent
    data class OnAddToCart(val item: CartItem) : MenuEvent
    data class OnIncrementQuantity(val itemId: Int, val newQuantity: Int) : MenuEvent
}