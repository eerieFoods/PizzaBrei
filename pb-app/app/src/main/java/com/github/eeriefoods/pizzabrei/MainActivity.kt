package com.github.eeriefoods.pizzabrei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.github.eeriefoods.pizzabrei.ui.PizzaBreiViewModel
import com.github.eeriefoods.pizzabrei.ui.navigation.NavGraph
import com.github.eeriefoods.pizzabrei.ui.theme.PizzaBreiTheme

class MainActivity : ComponentActivity() {

    private val pizzabreiViewModel = PizzaBreiViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaBreiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavGraph(pizzabreiViewModel)
                }
            }
        }
    }
}
