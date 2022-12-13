package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.presentation.theme.Blue
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme

@Composable
fun ReviewCard(review: Review, modifier: Modifier){
    PizzaBreiTheme {
        Card (
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        ){
            Box(modifier = Modifier.height(10.dp).padding(8.dp)){
                Text(review.reviewID)
            }
        }
    }
}