package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme

@Composable
fun AppCard(application: Application, modifier: Modifier){
    PizzaBreiTheme {
        Card (
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        ){
            Box(modifier = Modifier.height(100.dp).padding(8.dp)){
                if(application.images != null){
                    Image(application.images[0], contentDescription = "preview Images")
                }else{
                    Image(Icons.Default.Warning, contentDescription = "preview Images")
                }
                Text(application.name!!)
            }
        }
    }
}
