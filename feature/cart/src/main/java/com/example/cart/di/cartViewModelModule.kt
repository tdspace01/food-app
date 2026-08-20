package com.example.cart.di

import com.example.cart.presentation.view_model.CartViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val cartViewModelModule = module {
    viewModelOf(::CartViewModel)
}