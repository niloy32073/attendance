package com.example.attendance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendance.navigation.Routes
import com.example.attendance.ui.theme.Purple40
import com.example.attendance.ui.theme.Purple80

@Composable
fun BottomBar(navController: NavController){
    Row(modifier = Modifier.fillMaxWidth().background(Color(227, 229, 229)).padding(5.dp)) {
        Column(modifier = Modifier.fillMaxWidth(.5f).clickable { navController.navigate(Routes.Home.routes) }, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Outlined.Home, contentDescription = "home" , tint = if (navController.currentBackStackEntry?.destination?.route =="home") Purple40 else Color.Black)
            Text(text = "হোম", color = if (navController.currentBackStackEntry?.destination?.route =="home") Purple40 else Color.Black)
        }
        Column(modifier = Modifier.fillMaxWidth().clickable { navController.navigate(Routes.Profile.routes) },verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Outlined.Person, contentDescription = "profile", tint = if (navController.currentBackStackEntry?.destination?.route =="profile") Purple40 else Color.Black)
            Text(text = "প্রোফাইল", color = if (navController.currentBackStackEntry?.destination?.route =="profile") Purple40 else Color.Black)
        }
    }
}

