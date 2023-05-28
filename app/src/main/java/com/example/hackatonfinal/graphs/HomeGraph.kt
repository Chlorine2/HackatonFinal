package com.example.hackatonfinal.graphs

import DetailsScreen
import android.os.Build
import android.telecom.Call.Details
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hackatonfinal.R
import com.example.hackatonfinal.Screens.Event
import com.example.hackatonfinal.Screens.ProfileScreen.Awards
import com.example.hackatonfinal.Screens.ProfileScreen.AwardsScreen
import com.example.hackatonfinal.Screens.ProfileScreen.CompaniesScreen
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
            MyScreen(navController)
        }
        composable(ListOfScreens.Notifications.name){
            Text(text = "Hello")
        }

        composable(ListOfScreens.Companies.name){
            CompaniesScreen(navController)
        }

        composable(ListOfScreens.Awards.name){
            AwardsScreen(navController)
        }

        composable(ListOfScreens.Detail.name){
            //DetailsScreen()
        }





    }


}


