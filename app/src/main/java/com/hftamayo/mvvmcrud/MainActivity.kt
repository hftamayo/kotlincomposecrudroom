package com.hftamayo.mvvmcrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.hftamayo.mvvmcrud.navigation.NavManager
import com.hftamayo.mvvmcrud.room.UsersDatabase
import com.hftamayo.mvvmcrud.ui.theme.MvvmcrudTheme
import com.hftamayo.mvvmcrud.viewmodels.UsersViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmcrudTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, UsersDatabase::class.java, "db_users").build()
                    val dao = database.usersDao()

                    val viewModel = UsersViewModel(dao)
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}
