package com.github.eeriefoods.pizzabrei.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Screens
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme

@Composable
fun settingsScreen(navController: NavController){
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