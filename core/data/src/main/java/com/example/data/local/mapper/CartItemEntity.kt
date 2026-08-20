package com.example.data.local.mapper

import com.example.data.local.entity.CartItemEntity
import com.example.domain.model.CartItem

fun CartItemEntity.toDomain(): CartItem {
    return CartItem(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        imageResId = this.imageResId,
        quantity = this.quantity
    )
}

fun CartItem.toEntity(): CartItemEntity {
    return CartItemEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        imageResId = this.imageResId,
        quantity = this.quantity,
        addedAt = System.currentTimeMillis()
    )
}