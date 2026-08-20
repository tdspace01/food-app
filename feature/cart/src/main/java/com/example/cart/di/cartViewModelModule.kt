package com.example.cart.di

import com.example.cart.presentation.CartViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

val cartViewModelModule = module {
    viewModelOf(::CartViewModel)
}