package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Views
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel


@Composable
fun TopBar(navController: NavController, viewModel: HomeViewModel){
    PizzaBreiTheme {
        Box (Modifier.background(MaterialTheme.colorScheme.background)){
            Card(shape = RoundedCornerShape(15.dp), modifier = Modifier.padding(8.dp)) {
                Box(modifier = Modifier.padding(8.dp).fillMaxWidth().height(52.dp)) {
                    Row(Modifier.align(Alignment.CenterStart).focusRequester(viewModel.focusRequester)) {
                        Box(
                            Modifier.clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer).size(52.dp)
                                .clickable {
                                    navController.navigate(Views.Upload.route)
                                }) {
                            Text("U", Modifier.align(Alignment.Center))
                        }
                        Box(Modifier.clip(CircleShape).fillMaxSize()){
                            TextField(
                                value = viewModel.searchText.value,
                                onValueChange = {
                                    viewModel.searchText.value = it
                                },
                                label = { Text("Search") },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth().padding(start = 8.dp)
                            )
                            Icon(
                                Icons.Rounded.Search,
                                contentDescription = "Search Icon",
                                Modifier.align(Alignment.CenterEnd).padding(8.dp)
                            )
                        }
                    }
                }
            }
            Divider(Modifier.padding(bottom = 4.dp))
        }
    }
}
