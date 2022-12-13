package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.ReviewCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.TopBar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){

    LaunchedEffect(Unit, block = {
        viewModel.getApplications()
        viewModel.getReviews()
//        viewModel.getScreenSize()
    })
    Column {
        TopBar(navController)
        ShowApps(viewModel)
    }


}
@Composable
private fun ShowApps(viewModel : HomeViewModel) {
    LazyColumn {
        items(viewModel.applications) {
            AppCard(it, Modifier.padding(8.dp))
            Button(onClick = {
                putApp(it,viewModel)
            }){
                Text("app")
            }
        }
        items(viewModel.reviews) {
            ReviewCard(it, Modifier.padding(8.dp))
            Button(onClick = {
                putReview(it, viewModel)
            }) {
                Text("rev")
            }
        }
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