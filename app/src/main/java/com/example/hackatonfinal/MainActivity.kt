package com.example.hackatonfinal

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hackatonfinal.graphs.HomeNavGraph
import com.example.hackatonfinal.graphs.ListOfScreens
import com.example.hackatonfinal.graphs.RootNavigationGraph
import com.example.hackatonfinal.ui.theme.HackatonFinalTheme
import com.example.hackatonfinal.ui.theme.green40
import com.example.hackatonfinal.viewModel.AppUiState
import com.example.hackatonfinal.viewModel.SharedViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HackatonFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {

                    val viewModel : SharedViewModel = viewModel()
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(navController: NavHostController = rememberNavController(), viewModel: SharedViewModel) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            androidx.compose.material3.BottomAppBar(
                containerColor = green40,
                contentColor = Color.White,
                modifier = Modifier.height(56.dp)
            ) {
                bottomNavItems.forEachIndexed { index, item ->
                    val selected = item.route == backStackEntry.value?.destination?.route

                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate(item.route) },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = "Icon",
                                tint = Color.White
                            )
                        }
                    )
                }
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                HomeNavGraph(navController, viewModel = viewModel)
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HackatonFinalTheme {
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    viewModel: SharedViewModel,
) {
    when (viewModel.appUiState) {
        is AppUiState.Loading -> Text(text = "loading...", fontSize = 30.sp)
        is AppUiState.Success -> RootNavigationGraph(navController = rememberNavController(), viewModel)
        is AppUiState.Error -> Text(text = "Error", fontSize = 30.sp)
    }
}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        name = "Search",
        route = ListOfScreens.SearchProject.name,
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        name = "Notifications",
        route = ListOfScreens.Notifications.name,
        icon = Icons.Rounded.Notifications,
    ),
    BottomNavItem(
        name = "Profile",
        route = ListOfScreens.Profile.name,
        icon = Icons.Rounded.Settings,
    ),
)

