package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.home.HomeViewModel

@Composable
fun AppCard(application: Application, modifier: Modifier, viewModel: HomeViewModel){
    PizzaBreiTheme {
        Card (
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        ){
            Box(modifier = Modifier.height(100.dp).padding(8.dp)){
                Text(application.name)
            }
        }
    }
}
