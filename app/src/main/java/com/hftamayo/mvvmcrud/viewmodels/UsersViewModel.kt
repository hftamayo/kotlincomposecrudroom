package com.hftamayo.mvvmcrud.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hftamayo.mvvmcrud.models.Users
import com.hftamayo.mvvmcrud.room.UsersDatabaseDao
import com.hftamayo.mvvmcrud.states.UsersState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UsersViewModel(
    private val dao: UsersDatabaseDao
): ViewModel() {
    var state by mutableStateOf(UsersState())
    private set

    init {
        viewModelScope.launch {
            dao.getUsers().collectLatest {
                state = state.copy(
                    listUsers = it
                )
            }
        }
    }

    fun addUser(user: Users)= viewModelScope.launch {
        dao.addUser(user = user)
    }

    fun updateUser(user: Users) = viewModelScope.launch {
        dao.updateUser(user = user)
    }

    fun deleteUser(user: Users) = viewModelScope.launch {
        dao.deleteUser(user = user)
    }
}