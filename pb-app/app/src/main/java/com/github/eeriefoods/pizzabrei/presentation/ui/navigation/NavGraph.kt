package com.github.eeriefoods.pizzabrei.presentation.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.search.SearchScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.settings.SettingsScreen

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    viewModel: HomeViewModel,
    startRoute: String = Screens.Home.route
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startRoute)
    {
        composable(route = Screens.Home.route){
            HomeScreen(navController,viewModel)
        }
        composable(route = Screens.Settings.route){
            SettingsScreen(navController)
        }
        composable(route = Screens.Search.route){
            SearchScreen(navController)
        }
    }
}