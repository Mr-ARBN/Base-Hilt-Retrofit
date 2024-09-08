package com.example.basehiltretrofit.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basehiltretrofit.data.entity.local.TestUser

@Database(entities = [TestUser::class], version = 1)
abstract class TestDatabase : RoomDatabase() {
    abstract fun testUserDao(): TestUserDao
}