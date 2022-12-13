package com.github.eeriefoods.pizzabrei.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.R
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.AppCard
import com.github.eeriefoods.pizzabrei.presentation.ui.cards.ReviewCard
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Screens
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){

    LaunchedEffect(Unit, block = {
        viewModel.getApplications()
        viewModel.getReviews()
    })
    ShowApps(navController, viewModel)

}
@Composable
private fun ShowApps(navController: NavController, viewModel : HomeViewModel) {
    PizzaBreiTheme {
        Column {
            Box(modifier = Modifier
                .height(100.dp)
                .align(Alignment.CenterHorizontally)) {
                Column {
                    Text(
                        text = "ddddddd",
                        modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    )
                    Button(
                        onClick = {
                            navController.navigate(Screens.Settings.route)
                        }) {
                        Text("Einstellungen")
                    }
                    Button(
                        onClick = {
                            navController.navigate(Screens.Upload.route)
                        }) {
                        Text("Upload")
                    }
                }
            }

            LazyColumn {
//                items(viewModel.applications) {
//                    AppCard(it, Modifier.padding(8.dp), viewModel)
//                    Button(onClick = {
//                        putApp(it,viewModel)
//                    }){
//                        Text("app")
//                    }
//                }

                item {
                    AppCard(
                        application = Application(
                            "ID", "WhatsApp", "", "Number one Massenger Application", images = listOf(painterResource(id = R.mipmap.app1_icon)),
                            version = "2.312.72-SNAPSHOT"
                        ),
                        modifier = Modifier.padding(8.dp),
                        viewModel = viewModel
                    )
                }
                item {
                    AppCard(
                        application = Application(
                            "ID", "Instagram", "", "Share your photos now!", images = listOf(painterResource(id = R.mipmap.app2_icon)),
                            version = "17.9.2"
                        ),
                        modifier = Modifier.padding(8.dp),
                        viewModel = viewModel
                    )
                }
                item {
                    AppCard(
                        application = Application(
                            "ID", "Duolingo", "", "Learn new languages every day", images = listOf(painterResource(id = R.mipmap.app3_icon)),
                            version = "BETA-3.9.102"
                        ),
                        modifier = Modifier.padding(8.dp),
                        viewModel = viewModel
                    )
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
    }
}

fun putApp(application: Application, viewModel: HomeViewModel){
    GlobalScope.launch { viewModel.putApplication(application)}
}
fun putReview(review: Review, viewModel: HomeViewModel){
    GlobalScope.launch { viewModel.putReview(review) }
}