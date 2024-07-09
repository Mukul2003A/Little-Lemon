package com.example.littlelemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Screen", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        ClickableTextOption("Add Account") {
            // Handle Add Account logic
        }

        ClickableTextOption("Sign Out") {
            // Handle Sign Out logic
        }

        ClickableTextOption("Manage Account") {
            // Handle Manage Account logic
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Back to Home")
        }
    }
}

@Composable
fun ClickableTextOption(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    )
}

@Composable
fun HelpScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Help Screen", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Section(title = "FAQs for Food Ordering") {
            ExpandableDropdown(title = "Q: How can I place an order?") {
                Text("A: You can place an order by selecting dishes from our menu and proceeding to checkout.")
            }
            ExpandableDropdown(title = "Q: Can I customize my order?") {
                Text("A: Yes, you can customize your order by selecting options available for each dish.")
            }
            ExpandableDropdown(title = "Q: How do I cancel my order?") {
                Text("A: You can cancel your order from the order history section before it is confirmed.")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Section(title = "Contact Us") {
            Text("For support or inquiries, please contact us at:")
            Text("Phone: +1 (123) 456-7890")
            Text("Email: support@littlelemon.com")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Back to Home")
        }
    }
}

@Composable
fun OrderHistoryScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Order History Screen", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        ClickableTextOption("View Order Details") {
            // Handle View Order Details logic
        }

        ClickableTextOption("Reorder") {
            // Handle Reorder logic
        }

        ClickableTextOption("Track Order") {
            // Handle Track Order logic
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Back to Home")
        }
    }
}




@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Settings Screen", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Section(title = "Appearance Settings") {
            ExpandableDropdown(title = "Choose your preferred theme:") {
                Text("- Dark Mode")
                Text("- Light Mode")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Section(title = "Notification Settings") {
            ExpandableDropdown(title = "Configure your notification preferences here.") {
                // Add content if needed
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Section(title = "About") {
            Text("Little Lemon App Version 1.0")
            Text("Developed by Your Company")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Back to Home")
        }
    }
}

@Composable
fun DropdownMenuButton(options: List<String>, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    Box {
        Button(onClick = { expanded = true }) {
            Text(text = if (selectedOption.isEmpty()) "Select an option" else selectedOption)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedOption = option
                            expanded = false
                            onSelect(option)
                        }
                        .padding(8.dp)
                ) {
                    Text(text = option)
                }
            }
        }
    }
}




@Composable
fun ExpandableDropdown(title: String, content: @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        if (expanded) {
            content()
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        content()
    }
}
