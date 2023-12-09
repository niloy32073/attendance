package com.example.attendance

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attendance.navigation.Routes
import com.example.attendance.screens.Attendance
import com.example.attendance.screens.Home
import com.example.attendance.screens.Login
import com.example.attendance.screens.Profile
import com.example.attendance.screens.SignUp
import com.example.attendance.ui.theme.AttendanceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.LogIn.routes) {
                        composable(Routes.LogIn.routes) {
                            Login(navController)
                        }
                        composable(Routes.Home.routes) {
                            Home(navController)
                        }
                        composable(Routes.SignUp.routes) {
                            SignUp(navController)
                        }
                        composable(Routes.Profile.routes) {
                            Profile(navController)
                        }
                        composable(Routes.Attendance.routes) {
                            Attendance()
                        }
                    }
                }
            }
        }
    }
}
