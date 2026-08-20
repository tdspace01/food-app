package com.example.menu.di

import com.example.menu.presentation.view_model.MenuViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val menuViewModelModule = module {
    viewModelOf(::MenuViewModel)
}