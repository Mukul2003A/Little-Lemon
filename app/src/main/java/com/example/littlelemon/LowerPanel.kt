package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Categ = listOf("Lunch", "Dessert", "A La Carte", "Mains")

@Composable
fun LowerPanel() {
    var selectedCategory by remember { mutableStateOf("All") }

    Column {
        WeeklySpecial()
        CategoryMenu(
            categories = Categ,
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )
        MenuDishes(selectedCategory = selectedCategory)
    }
}

@Composable
fun WeeklySpecial(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Text(
            text = "Weekly Special",
            color = LittleLemonColor.charcoal,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun CategoryMenu(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow {
        items(categories) { category ->
            MenuCategory(
                category = category,
                isSelected = category == selectedCategory,
                onCategorySelected = onCategorySelected
            )
        }
    }
}

@Composable
fun MenuCategory(
    category: String,
    isSelected: Boolean,
    onCategorySelected: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(if (isSelected) LittleLemonColor.green else Color.LightGray)
            .clickable { onCategorySelected(category) }
    ) {
        Text(
            text = category,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MenuDishes(selectedCategory: String) {
    val filteredDishes = if (selectedCategory == "All") {
        Dishes
    } else {
        Dishes.filter { it.category == selectedCategory }
    }

    LazyColumn {
        items(filteredDishes) { dish ->
            MenuDishCard(dish)
        }
    }
}

@Composable
fun MenuDishCard(dish: Dish) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = dish.name,
                color = LittleLemonColor.charcoal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = dish.description,
                color = LittleLemonColor.green,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth(.75f)
            )
            Text(
                text = dish.price,
                color = LittleLemonColor.green,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
