package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}

@Composable
fun WeeklySpecial(){
    Card(modifier = Modifier
        .fillMaxWidth()) {
        Text(
            text = "Weekly Special", color = LittleLemonColor.charcoal, fontSize = 26.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp)
        )
    }
}


@Composable
fun MenuDish() {
    Card {
        Column {
            LazyRow{
                items(Categories){
                        category ->
                    MenuCategory(category)
                }
            }
            LazyColumn {
                items(Dishes) { Dish ->
                    MenuDish(Dish)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
