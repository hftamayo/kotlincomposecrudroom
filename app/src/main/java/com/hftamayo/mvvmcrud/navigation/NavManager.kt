package com.hftamayo.mvvmcrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hftamayo.mvvmcrud.viewmodels.UsersViewModel
import com.hftamayo.mvvmcrud.views.AddView
import com.hftamayo.mvvmcrud.views.HomeView

@Composable
fun NavManager(viewModel: UsersViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeView(navController, viewModel)
        }

        composable("add") {
            AddView(navController, viewModel)
        }

        composable("edit/{id}/{user}/{email}", arguments = listOf(
            navArgument("id"){ type = NavType.IntType },
            navArgument("user"){ type = NavType.StringType },
            navArgument("email"){ type = NavType.StringType }
        )) {
            EditView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments!!.getString("user"),
                it.arguments!!.getString("email")
            )
        }
    }
}