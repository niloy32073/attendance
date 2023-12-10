package com.example.attendance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendance.data.StudentClass
import com.example.attendance.database.student.Student
import com.example.attendance.database.student.StudentViewModel
import com.example.attendance.ui.theme.Purple40
import com.example.attendance.ui.theme.Purple80

@Composable
fun StudentColumn(student: Student, studentViewModel: StudentViewModel) {
    val id = student.id
    val name = student.name
    var absent by remember { mutableIntStateOf(student.absent) }
    var attendance by remember { mutableIntStateOf(student.present) }
    Row(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .background(Purple80),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                absent++
                studentViewModel.updateStudent(
                    Student(
                        id = id,
                        name = name,
                        classId = student.classId,
                        schoolId = student.schoolId,
                        present = student.present,
                        absent = absent
                    )
                ) //abasent++
                },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.width(60.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = Color.White,
                    contentDescription = "Absent"
                )
                Text(text = "${absent}")
            }
        }

        Text(text = "রোল : ${id} ,  নাম : ${name}")

        Button(
            onClick = {
                attendance++
                studentViewModel.updateStudent(
                    Student(
                        id = id,
                        name = name,
                        classId = student.classId,
                        schoolId = student.schoolId,
                        present = attendance,
                        absent = student.absent
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            modifier = Modifier.width(65.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = Color.White,
                    contentDescription = "Absent"
                )
                Text(text = "${attendance}")
            }
        }
    }
}
