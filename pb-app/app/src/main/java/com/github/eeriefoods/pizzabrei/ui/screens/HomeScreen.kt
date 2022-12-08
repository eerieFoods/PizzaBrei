package com.github.eeriefoods.pizzabrei.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.dataclasses.Application
import com.github.eeriefoods.pizzabrei.ui.PizzaBreiViewModel
import com.github.eeriefoods.pizzabrei.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.ui.navigation.Screens
import com.github.eeriefoods.pizzabrei.ui.theme.PizzaBreiTheme

data class HomeUiState(
    val isDev: Boolean = false,
//    val  apps: List<Apps> = listOf()
)
@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: PizzaBreiViewModel){
    PizzaBreiTheme {
        Column {
            Box(modifier = Modifier.height(100.dp).align(Alignment.CenterHorizontally)){
                Column {
                    Text(
                        text = ("dasddaasdddddddddddd"),
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

            val itemsList: List<Application> = listOf(Application("a","b","cc" ), Application("d","e","ff"))

            LazyColumn{
                items(itemsList){
                    AppCard(it,Modifier.padding(8.dp))
                }
            }
        }
    }
}