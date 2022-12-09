package com.github.eeriefoods.pizzabrei.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.domain.model.Application as App
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Screens
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.ReviewCard

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){

    LaunchedEffect(Unit, block = {
        viewModel.getApplications()
    })
    ShowApps(navController, viewModel)
}

@Composable
private fun ShowApps(navController: NavController, viewModel : HomeViewModel){
    PizzaBreiTheme {
        Column {
            Box(modifier = Modifier.height(100.dp).align(Alignment.CenterHorizontally)){
                Column {
                    Text(
                        text = "ddddddd",
                        modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    )
                    Button(
                        onClick = {
                            navController.navigate(Screens.Settings.route)
                        }) {
                        Text("Einstellungen")
                    }
                }
            }

            LazyColumn{
                items(viewModel.applications){
                    AppCard(it,Modifier.padding(8.dp))
                }
                items(viewModel.reviews){
                    ReviewCard(it, Modifier.padding(8.dp))
                }
            }
        }
    }
}