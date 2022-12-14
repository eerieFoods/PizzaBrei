package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.RecomendedAppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.TopBar
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){

    LaunchedEffect(viewModel){
        viewModel.getApplications()
        viewModel.getReviews()
        viewModel.getRandomApp()
    }

    val numberOfItemsByRow = LocalConfiguration.current.screenWidthDp / 200
    LazyColumn{
        item(contentType = stickyHeader{TopBar(navController)}) {}
        item {
            ShowRecomendedApps(viewModel, navController)
        }
        item(contentType = stickyHeader { ShowCategoryButtons() }){}

        items(items = viewModel.applications.chunked(numberOfItemsByRow)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                for (app in rowItems) {
                    AppCard(app, Modifier.padding(8.dp).weight(1f),viewModel, navController)
                }
            }
            Spacer(Modifier.height(14.dp))
        }
    }
}
@Composable
private fun ShowRecomendedApps(viewModel: HomeViewModel,navController: NavController){
    PizzaBreiTheme {
        Column {
            Text("Empfohlen f??r dich: ",Modifier.padding(start = 16.dp))
            RecomendedAppCard(viewModel.recommendedApp, Modifier.padding(8.dp),viewModel, navController)
        }
    }
}

@Composable
private fun ShowCategoryButtons(){
    PizzaBreiTheme {
        Box (Modifier.background(MaterialTheme.colorScheme.surface).padding(8.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {}, Modifier){
                    Text("Kat1")
                }
                Button(onClick = {}, Modifier){
                    Text("Kat2")
                }
                Button(onClick = {}, Modifier){
                    Text("Kat3")
                }
            }
        }
        Divider(Modifier.padding(bottom = 4.dp))
    }
}

private fun putApp(application: Application, viewModel: HomeViewModel){
    MainScope().launch { viewModel.putApplication(application)}
}
private fun putReview(review: Review, viewModel: HomeViewModel){
    MainScope().launch { viewModel.putReview(review) }
}