package com.example.domain.usecase

import com.example.domain.model.CartItem
import com.example.domain.repository.CartRepository

class AddToCartUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(item: CartItem) {
        repository.addToCart(item)
    }
}