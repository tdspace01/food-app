package com.example.data.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.CartDao
import com.example.data.local.entity.CartItemEntity

@Database(
    entities = [CartItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val cartDao: CartDao
}