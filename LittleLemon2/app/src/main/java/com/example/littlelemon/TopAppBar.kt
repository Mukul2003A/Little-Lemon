package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(drawerState: DrawerState, scope: CoroutineScope) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically ) {
        IconButton(onClick = {
            scope.launch {
                drawerState.open()}
        }) {
            Image(painter = painterResource(id = R.drawable.hamburger), contentDescription = "Menu Icon", modifier = Modifier.size(24.dp).fillMaxWidth())
        }
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo", modifier = Modifier.fillMaxWidth(0.5f).padding(horizontal = 20.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = R.drawable.cart), contentDescription = "Cart", modifier = Modifier.size(24.dp).fillMaxWidth())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(drawerState = drawerState, scope = coroutineScope)
}
