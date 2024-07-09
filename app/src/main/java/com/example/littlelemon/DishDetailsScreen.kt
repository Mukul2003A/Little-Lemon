package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    // Display dish details using the provided parameters
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = description, fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Text(text = price, fontSize = 20.sp, color = LittleLemonColor.green)
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.size(200.dp).padding(vertical = 16.dp)
        )
        Text(text = "Category: $category", fontSize = 16.sp, modifier = Modifier.padding(bottom = 16.dp))

        // Buttons
        Row {
            Button(
                onClick = { /* Handle add to cart action */ },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "Add to Cart")
            }

            Button(
                onClick = { /* Handle order directly action */ },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Order Directly")
            }
        }
    }
}
