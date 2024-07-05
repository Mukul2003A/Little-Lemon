package com.example.littlelemon

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
                ModalDrawerSheet{
                    Spacer(modifier = Modifier.height(16.dp))
                    List(10){
                        Text(text = "item $it", modifier = Modifier.padding(horizontal = 20.dp, vertical=10.dp))
                    }
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(drawerState, scope)
                },
            ) {
                Column(Modifier.padding(it)) {
                    UpperPanel(navController) // Pass NavController to UpperPanel
                    LowerPanel()
                }
            }
        }
    }
}
