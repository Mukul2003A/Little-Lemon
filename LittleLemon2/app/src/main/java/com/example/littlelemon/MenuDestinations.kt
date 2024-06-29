package com.example.littlelemon

interface MenuDestinations {
    val route:String
}

object MenuDish : MenuDestinations{
    override val route = "MenuDish"
}

object DishDetails : MenuDestinations{
    override val route = "DishDetails"
}