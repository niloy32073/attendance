package com.example.attendance.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendance.components.BottomBar
import com.example.attendance.database.classroom.ClassViewModel
import com.example.attendance.navigation.Routes


@Composable
fun Home(navController: NavController , classViewModel: ClassViewModel){
    //val Classes = listOf<String>("৬ষ্ঠ শ্রেণি সেকশন : ক","৬ষ্ঠ শ্রেণি সেকশন : খ","৬ষ্ঠ শ্রেণি সেকশন : গ","৭ম শ্রেণি সেকশন : ক","৭ম শ্রেণি সেকশন : খ","৭ম শ্রেণি সেকশন : গ","৮ম শ্রেণি সেকশন : ক","৮ম শ্রেণি সেকশন : খ","৮ম শ্রেণি সেকশন : গ","৯ম শ্রেণি সেকশন : ক","৯ম শ্রেণি সেকশন : খ","৯ম শ্রেণি সেকশন : গ","১০ম শ্রেণি সেকশন : ক","১০ম শ্রেণি সেকশন : খ","১০ম শ্রেণি সেকশন : গ")
    val classList = classViewModel.allclass.observeAsState(listOf()).value
    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "শ্রেণি তালিকাঃ", modifier = Modifier.fillMaxWidth(.9f))

            LazyColumn{
                items(classList){Class->
                    Button(
                        onClick = { navController.navigate(Routes.Attendance.routes) },
                        modifier = Modifier.fillMaxWidth(.9f),
                        shape = RoundedCornerShape(5.dp)) {
                        Text(text = Class.name)
                    }
                }
            }


        }
        BottomBar(navController)
    }
}