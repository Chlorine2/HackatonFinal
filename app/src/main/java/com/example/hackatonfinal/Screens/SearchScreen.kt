package com.example.hackatonfinal.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.example.hackatonfinal.R
import com.example.hackatonfinal.viewModel.SharedViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun text(){
    Text("andriyLoh")
}
@Composable
fun SearchScreen(viewModel: SharedViewModel, onClick : () -> Unit){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        //var selectedIndex by remember { mutableStateOf(-1) }
//
        //LargeDropdownMenu(
        //    label = "Choose City",
        //    items = listOf("Education", "Environment", "Social", "War"),
        //    selectedIndex = selectedIndex,
        //    onItemSelected = { index, _ -> selectedIndex = index},

        val pictures = listOf(R.drawable.img_6, R.drawable.img_5, R.drawable.img)
        var count : Int = 0
        viewModel.GetAllProjects()

        LazyColumn {

            items(viewModel.allProjects.value){
                    data ->


                EventItemCard(data, onClick = {onClick()}, viewModel = viewModel, pictures[count], 295.dp)
                viewModel.updatePicture(pictures[count])
                count++
                if(count == 3){
                    count = 0
                }
            }
        }






    }



}

