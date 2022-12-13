package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme

@Composable
fun RecomendedAppCard(application: Application, modifier: Modifier){
    PizzaBreiTheme {
        Card (
            modifier = modifier,
            shape = RoundedCornerShape(15.dp),
            ){
            Box(modifier = Modifier.height(200.dp).fillMaxWidth().padding(8.dp)){
                Text(application.appID!!)
            }
        }
        Divider(Modifier.padding(bottom = 4.dp))
    }
}