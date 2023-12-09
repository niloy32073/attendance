package com.example.attendance.navigation

sealed class Routes(var routes:String){
    data object Home:Routes("home")
    data object LogIn:Routes("login")
    data object SignUp:Routes("signup")
    data object Profile:Routes("profile")
    data object Attendance:Routes("attendance")
}
