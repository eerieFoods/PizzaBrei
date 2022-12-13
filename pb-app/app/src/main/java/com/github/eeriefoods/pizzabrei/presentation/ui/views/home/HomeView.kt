package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.RecomendedAppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.TopBar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){

    LaunchedEffect(viewModel){
        viewModel.getApplications()
        viewModel.getReviews()
    }

    LazyColumn{
        item(contentType = stickyHeader{TopBar(navController)}) {}
        item {
            ShowRecomendedApps(viewModel)
        }
        item(contentType = stickyHeader { ShowCategoryButtons(viewModel) }){}

            items(viewModel.applications){
            AppCard(it, Modifier.padding(8.dp))
            AppCard(it, Modifier.padding(8.dp))
            AppCard(it, Modifier.padding(8.dp))
        }
    }
}
@Composable
private fun ShowRecomendedApps(viewModel: HomeViewModel){
    PizzaBreiTheme {
        Column {
            Text("Empfohlen für dich: ",Modifier.padding(start = 16.dp))
            RecomendedAppCard(viewModel.recommendedApplication, Modifier.padding(8.dp))
        }
    }
}

@Composable
private fun ShowCategoryButtons(viewModel: HomeViewModel){
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


@Composable
private fun ShowApps(lazyListScope: LazyListScope, viewModel: HomeViewModel){
    lazyListScope.items(viewModel.applications) {
        AppCard(it, Modifier.padding(8.dp))
        AppCard(it, Modifier.padding(8.dp))
        AppCard(it, Modifier.padding(8.dp))
    }
}







//        Column {
//            Box(modifier = Modifier.height(100.dp).align(Alignment.CenterHorizontally)) {
//                Column {
//                    Text(
//                        text = "ddddddd",
//                        modifier = Modifier.background(MaterialTheme.colorScheme.background),
//                    )
//                    Button(
//                        onClick = {
//                            navController.navigate(Screens.Settings.route)
//                        }) {
//                        Text("Einstellungen")
//                    }
//                }
//            }
//
//            LazyColumn {
//                items(viewModel.applications) {
//                    AppCard(it, Modifier.padding(8.dp))
//                    Button(onClick = {
//                        putApp(it,viewModel)
//                    }){
//                        Text("app")
//                    }
//                }
//                items(viewModel.reviews) {
//                    ReviewCard(it, Modifier.padding(8.dp))
//                    Button(onClick = {
//                        putReview(it, viewModel)
//                    }) {
//                        Text("rev")
//                    }
//                }
//            }
//        }
//    }

private fun putApp(application: Application, viewModel: HomeViewModel){
    GlobalScope.launch { viewModel.putApplication(application)}
}
private fun putReview(review: Review, viewModel: HomeViewModel){
    GlobalScope.launch { viewModel.putReview(review) }
}