package com.example.foodapp

import android.app.Application
import com.example.cart.di.cartViewModelModule
import com.example.menu.di.menuViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FoodApp)
            modules(
                menuViewModelModule,
                cartViewModelModule
            )
        }
    }
}