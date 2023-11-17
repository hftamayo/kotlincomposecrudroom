package com.hftamayo.mvvmcrud.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hftamayo.mvvmcrud.models.Users
import com.hftamayo.mvvmcrud.viewmodels.UsersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditView(navController: NavController, viewModel: UsersViewModel, id: Int, user: String?, email: String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Edit View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go Back",
                            tint = Color.White
                        )

                    }
                }
            )
        }
    ) {
        ContentEditView(it, navController, viewModel, id, user, email)
    }
}

@Composable
fun ContentEditView(it: PaddingValues, navController: NavController, viewModel: UsersViewModel, id: Int, user: String?, email: String?) {
    var user by remember { mutableStateOf(user) }
    var email by remember { mutableStateOf(email) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = user ?: "",
            onValueChange = { user = it },
            label = { Text(text = "User") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = email ?: "",
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                val user = Users(id = id, user = user!!, email = email!!)
                viewModel.updateUser(user)
                navController.popBackStack()
            }
        ) {
            Text(text = "Edit")
        }
    }
}