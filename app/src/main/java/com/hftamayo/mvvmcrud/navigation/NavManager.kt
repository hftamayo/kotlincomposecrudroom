package com.hftamayo.mvvmcrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hftamayo.mvvmcrud.viewmodels.UsersViewModel

@Composable
fun NavManager(viewModel: UsersViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home")
    }
}