package com.example.data.di.database

import androidx.room.Room
import com.example.data.local.roomdb.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                "foodgo_cart.db"
            ).fallbackToDestructiveMigration(false).build()
    }

    single { get<AppDatabase>().cartDao }
}