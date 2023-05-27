package com.example.hackatonfinal.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hackatonfinal.viewModel.SharedViewModel


enum class ListOfScreens(){

    Login(),
    Registration(),
    Reset(),
    SearchProject(),



}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RootNavigationGraph(navController: NavHostController, viewModel: SharedViewModel) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController, viewModel = viewModel)
        composable(route = Graph.HOME) {

        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}