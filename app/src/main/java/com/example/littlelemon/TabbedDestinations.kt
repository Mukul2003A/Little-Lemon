package com.example.littlelemon


interface TabbedDestinations {
    val route: String
    val icon: Int
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