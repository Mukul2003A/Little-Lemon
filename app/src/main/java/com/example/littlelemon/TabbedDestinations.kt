package com.example.littlelemon

interface TabbedDestinations {
    val route: String
    val icon: Int?
    val title: String
}

object Menu : TabbedDestinations {
    override val route = "Menu"
    override val icon = R.drawable.ic_menu
    override val title = "Menu"
}

object TabbedHome : TabbedDestinations {
    override val route = "Home"
    override val icon = R.drawable.ic_home
    override val title = "Home"
}

object Location : TabbedDestinations {
    override val route = "Location"
    override val icon = R.drawable.ic_location
    override val title = "Location"
}

object Cart : TabbedDestinations {
    override val route = "Cart"
    override val icon = R.drawable.cart // Ensure this icon resource exists
    override val title = "Cart"
}

object Profile : TabbedDestinations {
    override val route = "profile"
    override val icon: Int? = null // No icon needed for Profile
    override val title = "Profile"
}

object Help : TabbedDestinations {
    override val route = "help"
    override val icon: Int? = null // No icon needed for Help
    override val title = "Help"
}

object OrderHistory : TabbedDestinations {
    override val route = "order_history"
    override val icon: Int? = null // No icon needed for Order History
    override val title = "Order History"
}

object Settings : TabbedDestinations {
    override val route = "settings"
    override val icon: Int? = null // No icon needed for Settings
    override val title = "Settings"
}
