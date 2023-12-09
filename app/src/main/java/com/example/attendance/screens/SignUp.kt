package com.example.attendance.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendance.navigation.Routes
import com.example.attendance.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavController){
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var name by remember{ mutableStateOf("") }
    var eiin by remember{ mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(.9f),value = name, onValueChange = {name=it}, label = { Text(text = "নাম") }, placeholder = { Text(
            text = "আপনার নাম লিখুন"
        )
        })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(.9f),value = eiin, onValueChange = {eiin =it}, label = { Text(text = "ইআইআইএন") }, placeholder = { Text(
            text = "ইআইআইএন নাম্বার দিন"
        )
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal))
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(.9f),value = email, onValueChange = {email = it}, label = { Text(text = "ইমেইল") }, placeholder = { Text(
            text = "আপনার ইমেইল এড্রেস দিন"
        )
        })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(.9f),value = password, onValueChange = {password=it}, label = { Text(text = "পাসওয়ার্ড") }, placeholder = { Text(
            text = "পাসওয়ার্ড দিন"
        )
        }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.fillMaxWidth(.9f),onClick = { navController.navigate(Routes.Home.routes) }, shape = RoundedCornerShape(5.dp)) {
            Text(text = "একাউন্ট খুলুন")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(.9f), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
            Text(text = "একাউন্ট আছে ? ")
            Text(text = "লগইন করুন", modifier = Modifier.clickable { navController.navigate(Routes.LogIn.routes) }, color = Purple40, fontWeight = FontWeight(800))
        }
    }
}