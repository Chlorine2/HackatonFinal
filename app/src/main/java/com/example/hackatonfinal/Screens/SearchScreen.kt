package com.example.hackatonfinal.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.hackatonfinal.LargeDropdownMenu.LargeDropdownMenu
import com.example.hackatonfinal.LargeDropdownMenu.LargeDropdownMenuItem
import com.example.hackatonfinal.R

@Composable
fun SearchScreen(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {


        //var selectedIndex by remember { mutableStateOf(-1) }
//
        //LargeDropdownMenu(
        //    label = "Choose City",
        //    items = listOf("Education", "Environment", "Social", "War"),
        //    selectedIndex = selectedIndex,
        //    onItemSelected = { index, _ -> selectedIndex = index},
        //)

        val event = Event(
            photoResId = R.drawable.img,
            title = "Назва події",
            date = "27 травня 2023",
            time = "19:00 - 22:00",
            location = "Місце проведення",
            description = "Tra tra das"
        )

        EventItemCard(event = event)




    }



}