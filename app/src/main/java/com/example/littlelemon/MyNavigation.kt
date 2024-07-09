package com.example.littlelemon


import LocationScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) {
        Box(Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = Home.route) {
                composable(Menu.route) {
                    LowerPanel(navController)
                }
                composable(Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(Location.route) {
                    LocationScreen() // Use the updated LocationScreen
                }
                composable(Cart.route) {
                    CartScreen()
                }
                composable("Profile") {
                    ProfileScreen(navController = navController)
                }
                composable("Help") {
                    HelpScreen(navController = navController)
                }
                composable("OrderHistory") {
                    OrderHistoryScreen(navController = navController)
                }
                composable("Settings") {
                    SettingsScreen(navController = navController)
                }
                composable(
                    route = "dishDetails/{dishName}/{dishPrice}/{dishDescription}/{dishImage}/{dishCategory}",
                    arguments = listOf(
                        navArgument("dishName") { type = NavType.StringType },
                        navArgument("dishPrice") { type = NavType.StringType },
                        navArgument("dishDescription") { type = NavType.StringType },
                        navArgument("dishImage") { type = NavType.IntType },
                        navArgument("dishCategory") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val dishName = backStackEntry.arguments?.getString("dishName") ?: ""
                    val dishPrice = backStackEntry.arguments?.getString("dishPrice") ?: ""
                    val dishDescription = backStackEntry.arguments?.getString("dishDescription") ?: ""
                    val dishImage = backStackEntry.arguments?.getInt("dishImage") ?: 0
                    val dishCategory = backStackEntry.arguments?.getString("dishCategory") ?: ""

                    DishDetailsScreen(
                        name = dishName,
                        price = dishPrice,
                        description = dishDescription,
                        image = dishImage,
                        category = dishCategory
                    )
                }
            }
        }
    }
}




@Composable
fun MyBottomNavigation(navController: androidx.navigation.NavController) {
    val tabbedDestinationsList = listOf<TabbedDestinations>(
        TabbedHome,
        Menu,
        Location
    )
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation() {
        tabbedDestinationsList.forEachIndexed { index, tabbedDestinations ->
            BottomNavigationItem(label = { Text(text = tabbedDestinations.title) }, icon = { tabbedDestinations.icon?.let { painterResource(id = it) }
                ?.let { Icon(painter = it, contentDescription = tabbedDestinations.title) } },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(tabbedDestinationsList[index].route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                })
        }
    }
}
