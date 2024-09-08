package com.example.basehiltretrofit.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.basehiltretrofit.data.entity.local.TestUser

@Dao
interface TestUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(testUser: TestUser)

    @Query("SELECT * FROM testUsers")
    fun getAllUsers(): LiveData<List<TestUser>>

    @Query("SELECT * FROM testUsers WHERE uid = :userId LIMIT 1")
    suspend fun findById(userId: Int): TestUser?

    @Delete
    suspend fun delete(testUser: TestUser)

    @Upsert
    suspend fun upsert(testUser: TestUser)
}