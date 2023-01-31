package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.RecomendedAppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.TopBar

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){

    LaunchedEffect(viewModel){
        viewModel.getApplications()
        viewModel.getReviews()
    }

    val numberOfItemsByRow = LocalConfiguration.current.screenWidthDp / 200
    LazyColumn{
        item(contentType = stickyHeader{
            TopBar(navController,viewModel)}) {}
        item {
            ShowRecomendedApps(viewModel, navController)
        }
        item(contentType = stickyHeader { ShowCategoryButtons(viewModel) }){}

        items(items = viewModel.filteredApps.chunked(numberOfItemsByRow)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
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
            Text("Empfohlen für dich: ",Modifier.padding(start = 16.dp))
            RecomendedAppCard(viewModel.filteredApps.randomOrNull(), Modifier.padding(8.dp),viewModel, navController)
        }
    }
}

@Composable
private fun ShowCategoryButtons(viewModel: HomeViewModel){
    PizzaBreiTheme {
        Box (Modifier.background(MaterialTheme.colorScheme.surface).padding(8.dp)) {

            Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth().height(32.dp)){

            }


//            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
//                Button(onClick = {  }, Modifier){
//                    Text("Kat1")
//                }
//                Button(onClick = {}, Modifier){
//                    Text("Kat2")
//                }
//                Button(onClick = {}, Modifier){
//                    Text("Kat3")
//                }
//            }
        }
        Divider(Modifier.padding(bottom = 4.dp))
    }
}

