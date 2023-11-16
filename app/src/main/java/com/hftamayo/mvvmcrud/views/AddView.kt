package com.hftamayo.mvvmcrud.views

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.hftamayo.mvvmcrud.viewmodels.UsersViewModel

@Composable
fun AddView (navController: NavController, viewModel: UsersViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Add View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = , contentDescription = )

                    }
                }
            )
        }
    ) {

    }
}