package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

@Composable
fun DishDetails(dish: Dish){
    Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        val drawerState = DrawerState(initialValue = DrawerValue.Closed)
        val scope = CoroutineScope(MainScope().coroutineContext)
        TopAppBar(drawerState = drawerState, scope = scope)
        Image(painter = painterResource(id = dish.image), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            Text(text = dish.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = dish.description, style = MaterialTheme.typography.bodySmall)
            ItemOrder()
            Button(onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                Text(text = stringResource(id = R.string.add_for, dish.price), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

