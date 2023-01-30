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
import com.github.eeriefoods.pizzabrei.presentation.ui.views.settings.SettingsScreen
import com.github.eeriefoods.pizzabrei.presentation.ui.views.upload.UploadView
import com.github.eeriefoods.pizzabrei.presentation.ui.views.upload.UploadViewModel


@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun NavGraph(
    homeViewModel: HomeViewModel,
    uploadViewModel: UploadViewModel,
    startRoute: String = Views.Home.route,
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startRoute)
    {
        composable(route = Views.Home.route){
            HomeScreen(navController,homeViewModel)
        }
        composable(route = Views.Settings.route){
            SettingsScreen(navController)
        }
        composable(route = Views.Upload.route){
            UploadView(navController, uploadViewModel)
        }
        composable(route = Views.Detail.route){
            DetailView(homeViewModel, navController)
        }
    }
}