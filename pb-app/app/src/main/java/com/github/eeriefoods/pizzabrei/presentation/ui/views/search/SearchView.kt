package com.github.eeriefoods.pizzabrei.presentation.ui.views.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme

@Composable
fun SearchScreen(navController: NavController){
    PizzaBreiTheme {
        Column {
            Text("TODO SEARCH")
            Button(onClick = {
                navController.navigateUp()
            }){
                Text("GO BACK!!!!!")
            }
        }
    }
}