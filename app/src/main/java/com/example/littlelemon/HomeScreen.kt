package com.example.littlelemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    DrawerContent(navController)
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(drawerState = drawerState, scope = scope, navController = navController)
                },
            ) {
                Column(Modifier.padding(it)) {
                    UpperPanel(navController) // Pass NavController to UpperPanel
                    LowerPanel() // Pass NavController to LowerPanel
                }
            }
        }
    }
}

@Composable
fun DrawerContent(navController: NavController) {
    val drawerItems = listOf(
        "Profile",
        "Help",
        "Order History",
        "Settings"
    )

    Column {
        drawerItems.forEach { title ->
            DrawerItem(title = title) {
                when (title) {
                    "Profile" -> navController.navigate("Profile")
                    "Help" -> navController.navigate("Help")
                    "Order History" -> navController.navigate("OrderHistory")
                    "Settings" -> navController.navigate("Settings")
                }
            }
        }
    }
}

@Composable
fun DrawerItem(title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
    }
}
