package com.github.eeriefoods.pizzabrei.presentation.ui.navigation

sealed class Views(val route: String) {
    object Home: Views("home_screen")
    object Settings: Views("setting_screen")
    object Upload: Views("upload_screen")
    object Search: Views("search_screen")
    object Detail: Views("detail_screen")
}