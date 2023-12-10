package com.example.attendance.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attendance.R
import com.example.attendance.components.BottomBar
import com.example.attendance.database.classroom.ClassRoom
import com.example.attendance.database.classroom.ClassViewModel
import com.example.attendance.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController , classViewModel: ClassViewModel){
    var className by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var newPassword by remember{ mutableStateOf("") }
    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Column(modifier = Modifier
            .fillMaxWidth(.9f)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.teacher), contentDescription = "Teacher")
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(text = "নাম : মোঃ নিফাউর রহমান নিলয়")
                    Text(text = "পদবি : সহকারী শিক্ষক")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 1.dp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "ইমেইল : mdnifaurrahmanx27@gmail.com")
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 1.dp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "বিদ্যালয়ের নাম : জগতবেড় উচ্চ বিদ্যালয়")
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 1.dp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "নতুন শ্রেণি যোগ করুন")
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                OutlinedTextField(modifier = Modifier.fillMaxWidth(.6f), value = className, onValueChange = {className=it}, label = { Text(text = "শ্রেণির নাম")}, placeholder = { Text(
                    text = "শ্রেণির নাম লিখুন"
                )})
                Button(
                    modifier = Modifier.fillMaxWidth(.9f),
                    shape = RoundedCornerShape(5.dp),
                    onClick = {
                        classViewModel.inserclass(
                            ClassRoom(
                                name = className,
                                teacherId = 1,
                                schoolId = 10
                            )
                        )
                        className = ""
                    }) {
                    Text(text = "শ্রেণি যোগ করুন", textAlign = TextAlign.Center)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 1.dp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "পাসওয়ার্ড পরিবর্তন করুন")
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = password, onValueChange = {password=it}, label = { Text(text = "বর্তমান পাসওয়ার্ড")}, placeholder = { Text(
                    text = "বর্তমান পাসওয়ার্ড"
                )}, visualTransformation = PasswordVisualTransformation())
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = newPassword, onValueChange = {newPassword=it}, label = { Text(text = "নতুন পাসওয়ার্ড")}, placeholder = { Text(
                    text = "নতুন পাসওয়ার্ড"
                )}, visualTransformation = PasswordVisualTransformation())
                Spacer(modifier = Modifier.height(10.dp))
                Button(modifier = Modifier.fillMaxWidth(.9f), shape = RoundedCornerShape(5.dp),onClick = { password =""
                newPassword = ""}) {
                    Text(text = "পাসওয়ার্ড পরিবর্তন করুন")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 1.dp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier.fillMaxWidth(.9f), shape = RoundedCornerShape(5.dp),onClick = { navController.navigate(Routes.LogIn.routes) }) {
                    Text(text = "লগ আউট করুন")
                }
            }
        }
        BottomBar(navController)
    }
}

//@Preview
//@Composable
//fun PreviewProfile(){
//    val navController= rememberNavController()
//    Profile(navController = navController , classViewModel = classViewModel)
//}

