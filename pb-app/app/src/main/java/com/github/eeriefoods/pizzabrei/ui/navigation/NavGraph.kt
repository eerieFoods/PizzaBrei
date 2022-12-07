@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.github.eeriefoods.pizzabrei.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.eeriefoods.pizzabrei.ui.PizzaBreiViewModel
import com.github.eeriefoods.pizzabrei.ui.screens.homeScreen
import com.github.eeriefoods.pizzabrei.ui.screens.settingsScreen

@Composable
fun NavGraph (
    viewModel: PizzaBreiViewModel
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route){
            homeScreen(navController, viewModel)
        }
        composable(route = Screens.Settings.route){
            settingsScreen(navController, viewModel)
        }
    }
}