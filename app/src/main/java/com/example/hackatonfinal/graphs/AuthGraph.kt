package com.example.hackatonfinal.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hackatonfinal.Greeting
import com.example.hackatonfinal.Screens.LoginPage
import com.example.hackatonfinal.navigateSingleTopTo
import com.example.hackatonfinal.viewModel.SharedViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = ListOfScreens.Login.name
    ) {

        composable(ListOfScreens.Login.name){
            LoginPage(onClickLogin = {navController.navigate(Graph.HOME)},
            )
        }
        composable(ListOfScreens.Registration.name)
        {

        }
        composable(ListOfScreens.Reset.name)
        {

        }
    }
}