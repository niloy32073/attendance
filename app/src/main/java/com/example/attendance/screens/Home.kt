package com.example.attendance.screens

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.attendance.components.BottomBar


@Composable
fun Home(){
    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Classes", modifier = Modifier.fillMaxWidth(.9f))
            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(.7f).verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 6 Section A")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 6 Section B")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 6 Section C")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 7 Section A")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 7 Section B")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 7 Section C")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 8 Section A")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 8 Section B")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 8 Section C")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 9 Section A")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 9 Section B")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 9 Section C")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 10 Section A")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 10 Section B")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(.9f)) {
                    Text(text = "Class 10 Section C")
                }

            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Add New Class")
            }
        }
        BottomBar()
    }
}