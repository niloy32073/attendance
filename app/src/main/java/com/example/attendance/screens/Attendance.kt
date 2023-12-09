package com.example.attendance.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendance.components.StudentColumn
import com.example.attendance.data.StudentList

@Composable
fun Attendance(){
    val Students = StudentList()
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "শিক্ষার্থী তালিকা")
        LazyColumn{
            items(Students){student->
                Column {
                    StudentColumn(student)
                    Spacer(modifier = Modifier.height(10.dp))
                }
                
            }
        }
    }
}