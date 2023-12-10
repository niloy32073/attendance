package com.example.attendance.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.attendance.components.StudentColumn
import com.example.attendance.data.StudentList
import com.example.attendance.database.student.Student
import com.example.attendance.database.student.StudentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Attendance(studentViewModel: StudentViewModel) {
    val Students = StudentList()
    val studentList = studentViewModel.allStudent.observeAsState(listOf()).value
    var isAddStudentDialogOpen by mutableStateOf(false)
    Scaffold(
        floatingActionButton = { FloatinActionBtn(onActionBtnClick = {isAddStudentDialogOpen = true})},
        floatingActionButtonPosition = FabPosition.End,
        modifier = Modifier.fillMaxSize()
    ) {innerPadding->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "শিক্ষার্থী তালিকা")
            LazyColumn{
                items(studentList){student->
                    Column {
                        StudentColumn(student,studentViewModel)
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                }
            }
            if(isAddStudentDialogOpen){
                AddStudentDialog(onDismiss = {isAddStudentDialogOpen = false },studentViewModel)
            }
        }
    }
}

@Composable
fun FloatinActionBtn(onActionBtnClick: (Boolean) -> Unit) {
    FloatingActionButton(onClick = {
        onActionBtnClick(true)
    }) {
        Row {
            Icon(imageVector = Icons.Default.Add , contentDescription = null )
            Text(text = "Add Student")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudentDialog(onDismiss: () -> Unit , studentViewModel: StudentViewModel) {
    var roll by rememberSaveable {
        mutableStateOf("")
    }
    var name by rememberSaveable {
        mutableStateOf("")
    }
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
                        OutlinedButton(onClick = {
                            studentViewModel.inserStudent(
                                Student(
                                    name = name,
                                    id = roll.toInt(),
                                    absent = 0,
                                    present = 0,
                                    classId = 2,
                                    schoolId = 2
                                )
                            )
                        }) {
                            Text(text = "Save")
                        }
        },
        dismissButton = {
            OutlinedButton(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
            },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Top
            ) {
                OutlinedTextField(value = roll , onValueChange = {roll = it}, label = { Text(text = "Roll")} )
                OutlinedTextField(value = name , onValueChange = {name = it}, label = { Text(text = "Name")} )
            }
        }
    )
}

//onDismissRequest = { onDismiss() } ,
//confirmButton = {
//    studentViewModel.inserStudent(
//        Student(
//            name = name,
//            id = roll.toInt(),
//            absent = 0,
//            present = 0,
//            classId = 2,
//            schoolId = 2
//        )
//    )
//    onDismiss()
//},
//text = {
//    Column(
//        modifier = Modifier.fillMaxWidth().padding(10.dp),
//        verticalArrangement = Arrangement.Top
//    ) {
//        OutlinedTextField(value = roll , onValueChange = {roll = it}, label = { Text(text = "Roll")} )
//        OutlinedTextField(value = name , onValueChange = {name = it}, label = { Text(text = "Name")} )
//    }
//
//}