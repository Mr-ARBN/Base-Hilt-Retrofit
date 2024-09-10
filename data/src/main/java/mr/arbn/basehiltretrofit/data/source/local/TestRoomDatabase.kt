package mr.arbn.basehiltretrofit.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import mr.arbn.basehiltretrofit.data.entity.local.TestRoomUser

@Database(entities = [TestRoomUser::class], version = 1)
abstract class TestRoomDatabase : RoomDatabase() {
    abstract fun testUserDao(): TestRoomUserDao
}