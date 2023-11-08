package com.hftamayo.mvvmcrud.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("firstname")
    val firstname: String,
    @ColumnInfo("lastname")
    val lastname: String,
    @ColumnInfo("email")
    val email: String
)