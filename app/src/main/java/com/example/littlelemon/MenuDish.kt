package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuDish(Dish: Dish) {
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = LittleLemonColor.yellow,
        thickness = 1.dp
    )
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = Dish.name,
                    color = LittleLemonColor.charcoal,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = Dish.description,
                    color = LittleLemonColor.green,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = Dish.price,
                    color = LittleLemonColor.green,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = Dish.image),
                contentDescription = "",
                modifier=Modifier.size(80.dp).padding(8.dp)
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = LittleLemonColor.yellow,
        thickness = 1.dp
    )
}

@Composable
fun MenuCategory(categories: List<String>, onCategorySelected: (String) -> Unit) {
    Column {
        categories.forEach { category ->
            Button(
                onClick = { onCategorySelected(category) },
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                shape = RoundedCornerShape(40),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = category, color = Color.Black)
            }
        }
    }
}

data class Dish(
    val name: String,
    val price: String,
    val description: String,
    val image: Int,
    val category: String
)

// Add more dish examples
val Dishes = listOf(
    Dish(
        "Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad,
        "Lunch"
    ),
    Dish(
        "Bruschetta",
        "$5.99",
        "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta,
        "Lunch"
    ),
    Dish(
        "Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert,
        "Dessert"
    ),
    Dish(
        "Bacon Wrapped Scallops",
        "$10.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.baconwrappedscallops,
        "Lunch"
    ),
    Dish(
        "Caprese Skewers",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.capreseskewers,
        "A la Carte"
    ),
    Dish(
        "Churros",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.churros,
        "Dessert"
    ),
    Dish(
        "Deep Dish Pizza",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.deepdishpizza,
        "Lunch"
    ),
    Dish(
        "Donut Cake",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.donutcake,
        "Dessert"
    ),
    Dish(
        "Fattoush Stuffed Cucumber Cups",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.fattoushstuffedcucumbercups,
        "A la Carte"
    ),
    Dish(
        "Frog Bar",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.frog_bar,
        "Lunch"
    ),
    Dish(
        "Blue Berry Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lunch,
        "Lunch"
    ),
    Dish(
        "Marjolaine Cake",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.marjolainecake,
        "Dessert"
    ),
    Dish(
        "Passed Micro Sliders",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.passedmicrosliders,
        "A La Carte"
    ),
    Dish(
        "Pork Belly Burnt End Skewers",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.porkbellyburntendskewers,
        "A La Carte"
    ),
    Dish(
        "Shrimp Cocktail Shooters",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.shrimpcocktailshooters,
        "A La Carte"
    ),
    Dish(
        "Streak Bruschetta Shooters",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.steakbruschettashooters,
        "A La Carte"
    ),
    Dish(
        "Chocolate Tostada",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.chocolatetostada,
        "Dessert"
    ),
    Dish(
        "Egg Waffele",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.eggwaffle,
        "Dessert"
    ),
    Dish(
        "Formento Chocolate Cake",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.formentochocolatecake,
        "Dessert"
    ),
    Dish(
        "Lemon Sabayon Tart",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemonsabayontart,
        "Dessert"
    ),
    Dish(
        "Rainbow Cone",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.rainbowcone,
        "Dessert"
    )
)

@Composable
fun MenuScreen() {
    val categories = listOf("All", "Lunch", "Dessert", "A La Carte", "Mains")
    var selectedCategory by remember { mutableStateOf("All") }

    Column {
        MenuCategory(categories = categories) { category ->
            selectedCategory = category
        }
        Divider(
            modifier = Modifier.padding(horizontal = 8.dp),
            color = LittleLemonColor.yellow,
            thickness = 1.dp
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Dishes.filter {
                selectedCategory == "All" || it.name.contains(selectedCategory, ignoreCase = true)
            }.forEach { dish ->
                MenuDish(Dish = dish)
            }
        }
    }
}




