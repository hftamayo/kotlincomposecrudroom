package com.hftamayo.mvvmcrud.states

import com.hftamayo.mvvmcrud.models.Users

data class UsersState(
    val listUsers: List<Users> = emptyList()
)
