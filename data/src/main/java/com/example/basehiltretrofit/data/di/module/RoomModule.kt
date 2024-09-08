package com.example.basehiltretrofit.data.di.module

import android.content.Context
import androidx.room.Room
import com.example.basehiltretrofit.data.source.local.TestDatabase
import com.example.basehiltretrofit.data.source.local.TestUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TestDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TestDatabase::class.java,
            "database-name"
        ).build()
    }

    @Provides
    fun provideUserDao(database: TestDatabase): TestUserDao {
        return database.testUserDao()
    }
}