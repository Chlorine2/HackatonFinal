package com.example.hackatonfinal.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hackatonfinal.R
import com.example.hackatonfinal.ui.theme.green40
import com.example.hackatonfinal.viewModel.SharedViewModel

@Composable
fun SingleSearchScreen(viewModel: SharedViewModel){
    var count by remember { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {


        EventItemCard2(
            data = viewModel.currentProject.collectAsState().value,
            onClick = {},
            viewModel = viewModel,
            R.drawable.img
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(horizontalArrangement = Arrangement.Center){
            Button(onClick = {if(count > 0){count--}}, modifier = Modifier
                .width(70.dp)
                .height(70.dp), shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(green40)) {
                Text("-", fontSize = 35.sp)

            }
            Text(text = count.toString(), fontSize = 30.sp, modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp))

            Button(onClick = { if(count < 9){count++} }, modifier = Modifier
                .width(70.dp)
                .height(70.dp), shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(green40)) {

                Text("+", fontSize = 35.sp)

            }

        }

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth().padding(horizontal = 10.dp), shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(green40)) {
            Text("Write Hours", fontSize = 20.sp, fontWeight = FontWeight.Light)

        }
    }
}

@Composable
fun SingleNotificationScreen(viewModel: SharedViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        EventItemCard2(
            data = viewModel.currentProject.collectAsState().value,
            onClick = {},
            viewModel = viewModel,
            R.drawable.img
        )
    }
}