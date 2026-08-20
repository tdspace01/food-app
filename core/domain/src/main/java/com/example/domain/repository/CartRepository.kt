package com.example.domain.repository

import com.example.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItems(): Flow<List<CartItem>>
    suspend fun addToCart(item: CartItem)
    suspend fun updateQuantity(itemId: Int, newQuantity: Int)
    suspend fun removeFromCart(itemId: Int)
    suspend fun clearCart()
}