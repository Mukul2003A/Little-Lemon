package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DishDetailsScreen(
    name: String,
    price: String,
    description: String,
    image: Int,
    category: String
) {
    // Convert price to float for calculations
    val priceFloat = price.replace("$", "").toFloatOrNull() ?: 0f

    // State for quantity and total price
    var quantity by remember { mutableStateOf(1) }
    val totalPrice = priceFloat * quantity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = name, fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text(text = description, fontSize = 20.sp, modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Category: $category", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        }

        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .size(300.dp)
                .padding(vertical = 16.dp)
        )

        Text(text = "$${"%.2f".format(totalPrice)}", fontSize = 24.sp, color = LittleLemonColor.green)

        // Quantity buttons
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { if (quantity > 1) quantity-- },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "-", fontSize = 24.sp)
            }

            Text(text = "$quantity", fontSize = 24.sp, modifier = Modifier.padding(horizontal = 8.dp))

            Button(
                onClick = { quantity++ },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "+", fontSize = 24.sp)
            }
        }

        // Action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* Handle add to cart action */ }) {
                Text(text = "Add to Cart", fontSize = 20.sp)
            }

            Button(onClick = { /* Handle order directly action */ }) {
                Text(text = "Order Directly", fontSize = 20.sp)
            }
        }
    }
}
