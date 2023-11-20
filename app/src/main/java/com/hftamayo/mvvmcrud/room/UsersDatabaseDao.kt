package com.hftamayo.mvvmcrud.room

import androidx.room.*
import com.hftamayo.mvvmcrud.models.Users
import kotlinx.coroutines.flow.Flow


@Dao
interface UsersDatabaseDao {
    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<Users>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Flow<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: Users)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: Users)

    @Delete
    suspend fun deleteUser(user: Users)
}