package com.example.domain.model

data class CartItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResId: Int,
    val quantity: Int = 1
)
