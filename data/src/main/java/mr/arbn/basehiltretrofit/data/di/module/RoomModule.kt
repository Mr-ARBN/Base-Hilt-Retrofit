package mr.arbn.basehiltretrofit.data.di.module

import android.content.Context
import androidx.room.Room
import mr.arbn.basehiltretrofit.data.source.local.TestRoomDatabase
import mr.arbn.basehiltretrofit.data.source.local.TestRoomUserDao
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
    fun provideDatabase(@ApplicationContext context: Context): TestRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TestRoomDatabase::class.java,
            "database-name"
        ).build()
    }

    @Provides
    fun provideUserDao(database: TestRoomDatabase): TestRoomUserDao {
        return database.testUserDao()
    }
}