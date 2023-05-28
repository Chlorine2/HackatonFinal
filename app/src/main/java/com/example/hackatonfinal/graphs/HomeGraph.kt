package com.example.hackatonfinal.graphs

import DetailScreen
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
import com.example.hackatonfinal.Screens.EventItemCard
import com.example.hackatonfinal.Screens.NotificationScreen
import com.example.hackatonfinal.Screens.ProfileScreen.AwardElectro
import com.example.hackatonfinal.Screens.ProfileScreen.Awards
import com.example.hackatonfinal.Screens.ProfileScreen.AwardsItemCard2
import com.example.hackatonfinal.Screens.ProfileScreen.AwardsScreen
import com.example.hackatonfinal.Screens.ProfileScreen.AwardsScreen2
import com.example.hackatonfinal.Screens.ProfileScreen.CompaniesScreen
import com.example.hackatonfinal.Screens.ProfileScreen.HistoryCard
import com.example.hackatonfinal.Screens.ProfileScreen.MyScreen
import com.example.hackatonfinal.Screens.SearchScreen
import com.example.hackatonfinal.Screens.SingleNotificationScreen
import com.example.hackatonfinal.Screens.SingleSearchScreen
import com.example.hackatonfinal.navigateSingleTopTo
import com.example.hackatonfinal.viewModel.SharedViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeNavGraph(navController: NavHostController, viewModel: SharedViewModel) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = ListOfScreens.SearchProject.name
    ){
        composable(ListOfScreens.SearchProject.name){
            SearchScreen(viewModel = viewModel,onClick = {navController.navigateSingleTopTo(ListOfScreens.DetailProject.name)})
        }
        composable(ListOfScreens.Statistic.name){
            Text(text = "Hello")
        }
        composable(ListOfScreens.Profile.name){
            MyScreen(navController)
        }
        composable(ListOfScreens.Notifications.name){
            NotificationScreen(viewModel = viewModel, onClick = {navController.navigateSingleTopTo(ListOfScreens.DetailNotification.name)})


        }

        composable(ListOfScreens.Companies.name){
            CompaniesScreen(navController)
        }

        composable(ListOfScreens.AwardsSoftServe.name){
            AwardsScreen(navController)
        }
        composable(ListOfScreens.DetailProject.name){
            SingleSearchScreen(viewModel = viewModel)
        }
        composable(ListOfScreens.DetailNotification.name){
            SingleNotificationScreen(viewModel = viewModel)
        }

        composable(ListOfScreens.Detail.name){
            DetailScreen()
        }

        composable(ListOfScreens.AwardsTrans.name){
            AwardElectro(navController)
        }

        composable(ListOfScreens.AwardsConcerts.name){
            AwardsScreen2(navController)
        }





    }


}


