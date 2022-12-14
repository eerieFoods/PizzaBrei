@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.github.eeriefoods.pizzabrei.presentation.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.eeriefoods.pizzabrei.presentation.ui.home.HomeViewModel
import com.github.eeriefoods.pizzabrei.presentation.ui.home.HomeScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.screens.detailScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.screens.settingsScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.screens.uploadScreen


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
            settingsScreen(navController)
        }
        composable(route = Screens.Upload.route){
            uploadScreen(navController)
        }
        composable(route = Screens.Detail.route){
            detailScreen(navController)
        }
    }
}