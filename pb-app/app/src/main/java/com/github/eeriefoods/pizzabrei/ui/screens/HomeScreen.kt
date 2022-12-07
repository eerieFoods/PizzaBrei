package com.github.eeriefoods.pizzabrei.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.ui.PizzaBreiViewModel
import com.github.eeriefoods.pizzabrei.ui.cards.appCard
import com.github.eeriefoods.pizzabrei.ui.navigation.Screens
import com.github.eeriefoods.pizzabrei.ui.theme.PizzaBreiTheme

data class HomeUiState(
    val isDev: Boolean = false,
//    val  apps: List<Apps> = listOf()
)
@ExperimentalFoundationApi
@Composable
fun homeScreen(navController: NavController, viewModel: PizzaBreiViewModel){
    PizzaBreiTheme {
        Column {
            Box(modifier = Modifier.height(100.dp).align(Alignment.CenterHorizontally)){
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


            val itemsList = (0..50).toList()

            LazyColumn{
                stickyHeader{
                }

                items(itemsList){
                    appCard("test", Modifier.padding(top=6.dp, bottom = 3.dp))
                }
            }
        }
    }
}