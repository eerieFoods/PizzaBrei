package com.github.eeriefoods.pizzabrei.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.ui.PizzaBreiViewModel
import com.github.eeriefoods.pizzabrei.ui.navigation.Screens
import com.github.eeriefoods.pizzabrei.ui.theme.PizzaBreiTheme

@Composable
fun settingsScreen(navController: NavController, viewModel: PizzaBreiViewModel){
    PizzaBreiTheme {
        Column {
            Text("LOL")
            Button(onClick = {
                navController.navigate(Screens.Home.route)
            }){
                Text("GO BACK!!!!!")
            }
        }
    }

}