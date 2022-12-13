package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.home.HomeViewModel

@Composable
fun AppCard(application: Application, modifier: Modifier, viewModel: HomeViewModel) {
    PizzaBreiTheme {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        ) {
            Row {
                if (application.images != null && application.images.isNotEmpty())
                    Image(
                        painter = application.images.first(),
                        contentDescription = "",
                        modifier = modifier.clip(RoundedCornerShape(15.dp)),
                        alignment = Alignment.TopStart
                    )
                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .padding(8.dp)
                ) {
                    Text(
                        application.name,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column(modifier = modifier.padding(start = 5.dp)) {
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
