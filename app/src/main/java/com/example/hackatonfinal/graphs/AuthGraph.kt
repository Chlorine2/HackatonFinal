package com.example.hackatonfinal.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hackatonfinal.Greeting
import com.example.hackatonfinal.Screens.LoginPage
import com.example.hackatonfinal.Screens.RegistrationPage
import com.example.hackatonfinal.Screens.ResetPage
import com.example.hackatonfinal.navigateSingleTopTo
import com.example.hackatonfinal.viewModel.SharedViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController , viewModel : SharedViewModel) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = ListOfScreens.Login.name
    ) {

        composable(ListOfScreens.Login.name){
            LoginPage(onClickLogin = {navController.navigate(Graph.HOME)},
                onClickReset = {navController.navigateSingleTopTo(ListOfScreens.Reset.name)},
                onClickRegistration = {navController.navigateSingleTopTo(ListOfScreens.Registration.name)},
            viewModel = viewModel)
        }
        composable(ListOfScreens.Registration.name)
        {
            RegistrationPage(onClickReset = {navController.navigateSingleTopTo(ListOfScreens.Reset.name)},
                onClickSignUp = {navController.navigateSingleTopTo(ListOfScreens.Login.name)},
            viewModel = viewModel)
        }
        composable(ListOfScreens.Reset.name)
        {

            ResetPage(onClickSignUp = {navController.navigateSingleTopTo(ListOfScreens.Login.name)},)
        }
    }
}