package mr.arbn.basehiltretrofit.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import mr.arbn.basehiltretrofit.data.entity.local.TestRoomUser

@Dao
interface TestRoomUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(testRoomUser: TestRoomUser)

    @Query("SELECT * FROM testUsers")
    fun getAllUsers(): LiveData<List<TestRoomUser>>

    @Query("SELECT * FROM testUsers WHERE uid = :userId LIMIT 1")
    suspend fun findById(userId: Int): TestRoomUser?

    @Delete
    suspend fun delete(testRoomUser: TestRoomUser)

    @Upsert
    suspend fun upsert(testRoomUser: TestRoomUser)
}