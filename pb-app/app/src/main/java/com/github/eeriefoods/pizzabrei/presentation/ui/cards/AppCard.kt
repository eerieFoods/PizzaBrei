package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Views
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel
import com.github.eeriefoods.pizzabrei.R

@Composable
fun AppCard(application: Application, modifier: Modifier, viewModel: HomeViewModel,navController: NavController) {
    PizzaBreiTheme {
        Card(
            modifier = modifier.fillMaxWidth().clickable {
                viewModel.selectedApp = application
                navController.navigate(Views.Detail.route)
            },
            shape = RoundedCornerShape(15.dp),
        ) {
            Row {
                if (!application.images.isNullOrEmpty()) {
                    Image(
                        painter = application.images.first(),
                        contentDescription = "",
                        modifier = modifier.clip(RoundedCornerShape(15.dp)),
                        alignment = Alignment.TopStart
                    )
                }
                else {
                    val image = painterResource(id = R.mipmap.app1_icon)
                    Image(image, "test")
                }
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(8.dp)
                ) {

                    Column(modifier = modifier.padding(start = 5.dp)) {
                        Text(
                            application.name!!,
                            fontSize = 20.sp,
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

        }
    }
}
