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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.attendance.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(.9f),value = "", onValueChange = {}, label = { Text(text = "Email")}, placeholder = { Text(
            text = "Enter Your Email"
        )})
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(.9f),value = "", onValueChange = {}, label = { Text(text = "Password")}, placeholder = { Text(
            text = "Enter Your Password"
        )})
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.fillMaxWidth(.9f),onClick = { /*TODO*/ }, shape = RoundedCornerShape(5.dp)) {
            Text(text = "LogIn")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(.9f), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
            Text(text = "New User ? ")
            Text(text = "SignUp", modifier = Modifier.clickable { /*TODO*/ }, color = Purple40, fontWeight = FontWeight(800))
        }
    }
}