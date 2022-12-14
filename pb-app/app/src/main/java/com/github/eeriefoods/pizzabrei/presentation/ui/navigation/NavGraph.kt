package com.github.eeriefoods.pizzabrei.presentation.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.eeriefoods.pizzabrei.presentation.ui.views.detail.DetailView
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.search.SearchScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.settings.SettingsScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.upload.UploadView


@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun NavGraph(
    viewModel: HomeViewModel,
    startRoute: String = Views.Home.route,
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startRoute)
    {
        composable(route = Views.Home.route){
            HomeScreen(navController,viewModel)
        }
        composable(route = Views.Settings.route){
            SettingsScreen(navController)
        }
        composable(route = Views.Search.route){
            SearchScreen(navController)
        }
        composable(route = Views.Upload.route){
            UploadView(navController)
        }
        composable(route = Views.Detail.route){
            DetailView(viewModel, navController)
        }
    }
}