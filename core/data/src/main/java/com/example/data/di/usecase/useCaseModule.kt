package com.example.data.di.usecase

import com.example.domain.usecase.AddToCartUseCase
import com.example.domain.usecase.ClearCartUseCase
import com.example.domain.usecase.GetCartItemsUseCase
import com.example.domain.usecase.RemoveFromCartUseCase
import com.example.domain.usecase.UpdateCartQuantityUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCartItemsUseCase(repository = get()) }
    factory { AddToCartUseCase(repository = get()) }
    factory { UpdateCartQuantityUseCase(repository = get()) }
    factory { RemoveFromCartUseCase(repository = get()) }
    factory { ClearCartUseCase(repository = get()) }
}