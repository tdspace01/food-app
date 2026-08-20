package com.example.domain.usecase

import com.example.domain.repository.CartRepository

class RemoveFromCartUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(itemId: Int) {
        repository.removeFromCart(itemId)
    }
}