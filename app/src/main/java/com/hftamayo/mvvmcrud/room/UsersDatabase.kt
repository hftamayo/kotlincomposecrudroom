package com.hftamayo.mvvmcrud.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hftamayo.mvvmcrud.models.Users

@Database(
    entities = [Users::class],
    version = 1,
    exportSchema = false
)
abstract class UsersDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDatabaseDao

}
