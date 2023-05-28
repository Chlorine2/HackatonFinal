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
        //
        viewModel.GetAllProjects()
        LazyColumn {

            items(viewModel.allProjects.value){
                    data ->


                EventItemCard(data, onClick = {onClick()}, viewModel = viewModel, R.drawable.img, 295.dp)
            }
        }






    }



}