@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.github.eeriefoods.pizzabrei.presentation.ui.navigation

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.search.SearchScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.settings.SettingsScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.upload.uploadView


@ExperimentalFoundationApi
@Composable
fun NavGraph(
    viewModel: HomeViewModel,
    startRoute: String = Screens.Home.route,
    activity: Activity
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
        composable(route = Screens.Upload.route){
            uploadView(navController, activity)
        }
        composable(route = Screens.Detail.route){
            detailScreen(navController)
        }
    }
}