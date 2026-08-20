package com.example.data.di.repository

import com.example.data.repository.CartRepositoryImpl
import com.example.domain.repository.CartRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CartRepository> { CartRepositoryImpl(cartDao = get()) }
}