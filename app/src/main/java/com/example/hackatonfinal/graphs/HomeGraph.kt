package com.example.hackatonfinal.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hackatonfinal.R
import com.example.hackatonfinal.Screens.Event
import com.example.hackatonfinal.Screens.ProfileScreen.HistoryCard
import com.example.hackatonfinal.Screens.ProfileScreen.MyScreen
import com.example.hackatonfinal.Screens.SearchScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = ListOfScreens.SearchProject.name
    ){
        composable(ListOfScreens.SearchProject.name){
            SearchScreen()
        }
        composable(ListOfScreens.Statistic.name){
            Text(text = "Hello")
        }
        composable(ListOfScreens.Profile.name){
            MyScreen()
        }
        composable(ListOfScreens.Notifications.name){
            Text(text = "Hello")
        }



    }


}


