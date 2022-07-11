package com.commandiron.bubblenavigationbarcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBar
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBarItem
import com.commandiron.bubblenavigationbarcompose.ui.theme.BubbleNavigationBarComposeTheme

sealed class NavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val selectedColor: Color,
){
    object ScreenA : NavigationItem(
        title = "Home",
        route = "screenA",
        icon = Icons.Default.Home,
        selectedColor = Color(0xFF2a9d8f)
    )
    object ScreenB : NavigationItem(
        title = "Search",
        route = "screenB",
        icon = Icons.Default.Search,
        selectedColor = Color(0xFFe9c46a)
    )
    object ScreenC : NavigationItem(
        title = "Shop",
        route = "screenC",
        icon = Icons.Default.ShoppingCart,
        selectedColor = Color(0xFFf4a261)
    )
    object ScreenD : NavigationItem(
        title = "Settings",
        route = "screenD",
        icon = Icons.Default.Settings,
        selectedColor = Color(0xFFe76f51)
    )
}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BubbleNavigationBarComposeTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val navigationItems = NavigationItem::class.nestedClasses.map {
                    it.objectInstance as NavigationItem
                }
                Scaffold(
                    bottomBar = {
                        BubbleNavigationBar{
                            navigationItems.forEach { navigationItem ->
                                BubbleNavigationBarItem(
                                    selected = currentRoute == navigationItem.route,
                                    onClick = {
                                        if(currentRoute != navigationItem.route){
                                            navController.popBackStack()
                                            navController.navigate(navigationItem.route){
                                                navController.graph.startDestinationRoute?.let { screen_route ->
                                                    popUpTo(screen_route) {
                                                        saveState = true
                                                    }
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },
                                    icon = navigationItem.icon,
                                    title = navigationItem.title,
                                    selectedColor = navigationItem.selectedColor
                                )
                            }
                        }
                    }
                ) {
                    NavHost(navController = navController, startDestination = NavigationItem.ScreenA.route){
                        composable(NavigationItem.ScreenA.route){
                            ScreenA()
                        }
                        composable(NavigationItem.ScreenB.route){
                            ScreenB()
                        }
                        composable(NavigationItem.ScreenC.route){
                            ScreenC()
                        }
                        composable(NavigationItem.ScreenD.route){
                            ScreenD()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenA() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NavigationItem.ScreenA.selectedColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen A")
    }
}
@Composable
fun ScreenB() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NavigationItem.ScreenB.selectedColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen B")
    }
}
@Composable
fun ScreenC() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NavigationItem.ScreenC.selectedColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen C")
    }
}
@Composable
fun ScreenD() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NavigationItem.ScreenD.selectedColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen D")
    }
}