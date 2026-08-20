package com.example.data.repository

import com.example.data.local.dao.CartDao
import com.example.data.local.mapper.toDomain
import com.example.data.local.mapper.toEntity
import com.example.domain.model.CartItem
import com.example.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImpl(
    private val cartDao: CartDao
) : CartRepository {

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDao.getAllCartItems().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addToCart(item: CartItem) {
        val existingItem = cartDao.getCartItemById(item.id)
        if (existingItem != null) {
            val updated = existingItem.copy(quantity = existingItem.quantity + 1)
            cartDao.updateCartItem(updated)
        } else {
            cartDao.insertCartItem(item.toEntity())
        }
    }

    override suspend fun updateQuantity(itemId: Int, newQuantity: Int) {
        if (newQuantity <= 0) {
            cartDao.deleteCartItemById(itemId)
        } else {
            val existingItem = cartDao.getCartItemById(itemId)
            existingItem?.let {
                cartDao.updateCartItem(it.copy(quantity = newQuantity))
            }
        }
    }

    override suspend fun removeFromCart(itemId: Int) {
        cartDao.deleteCartItemById(itemId)
    }

    override suspend fun clearCart() {
        cartDao.clearCart()
    }
}