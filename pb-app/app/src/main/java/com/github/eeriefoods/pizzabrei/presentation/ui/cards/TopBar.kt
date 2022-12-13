package com.github.eeriefoods.pizzabrei.presentation.ui.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Screens

@Composable
fun TopBar(navController: NavController){
    PizzaBreiTheme {
        Box (Modifier.background(MaterialTheme.colorScheme.background)){
            Card(shape = RoundedCornerShape(15.dp), modifier = Modifier.padding(8.dp)) {
                Box(modifier = Modifier.padding(8.dp).fillMaxWidth().height(45.dp)) {
                    Row(Modifier.align(Alignment.CenterStart)) {
                        Box(
                            Modifier.clip(CircleShape).background(MaterialTheme.colorScheme.background).size(40.dp)
                                .clickable {
                                    navController.navigate(Screens.Settings.route)
                                }) {
                            Text("P", Modifier.align(Alignment.Center))
                        }
                        Box(Modifier.clip(CircleShape).fillMaxSize().clickable {
                            navController.navigate(Screens.Search.route)
                        }) {
                            Text("Search", Modifier.padding(8.dp).align(Alignment.CenterStart))
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
