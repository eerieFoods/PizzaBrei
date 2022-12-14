package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Views
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel

@Composable
fun RecomendedAppCard(application: Application, modifier: Modifier,viewModel: HomeViewModel,navController: NavController){
    PizzaBreiTheme {
        Card (
            modifier = modifier,
            shape = RoundedCornerShape(15.dp),
            ){
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        viewModel.selectedApp = application
                        navController.navigate(Views.Detail.route)
                    }
            ) {
                Column(modifier = modifier.padding(start = 5.dp)) {
                    Text(
                        application.name.toString(),
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(application.description.toString())
                    Text(
                        application.version.toString(),
                        modifier = modifier.padding(top = 5.dp),
                        color = Color.LightGray
                    )
                }
            }
        }
        Divider(Modifier.padding(bottom = 4.dp))
    }
}