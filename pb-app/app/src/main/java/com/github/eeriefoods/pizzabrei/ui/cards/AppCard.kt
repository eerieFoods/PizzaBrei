package com.github.eeriefoods.pizzabrei.ui.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.eeriefoods.pizzabrei.dataclasses.Application
import com.github.eeriefoods.pizzabrei.ui.theme.PizzaBreiTheme

@Composable
fun AppCard(app: Application, modifier: Modifier){
    PizzaBreiTheme {
        Card (
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        ){
            Box(modifier = Modifier.height(100.dp).padding(8.dp)){
                Text(app.name)
            }
        }
    }
}