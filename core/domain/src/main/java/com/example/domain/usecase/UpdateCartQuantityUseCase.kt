package com.example.domain.usecase

import com.example.domain.repository.CartRepository

class UpdateCartQuantityUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(itemId: Int, newQuantity: Int) {
        repository.updateQuantity(itemId, newQuantity)
    }
}