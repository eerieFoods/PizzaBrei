package com.github.eeriefoods.pizzabrei.presentation.ui.navigation

sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object Settings: Screens("setting_screen")
    object Upload: Screens("upload_screen")
    object Detail: Screens("detail_screen")
}