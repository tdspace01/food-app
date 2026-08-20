package com.example.menu.di

import com.example.menu.presentation.MenuViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val menuViewModelModule = module {
    viewModelOf(::MenuViewModel)
}