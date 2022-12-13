 @file:OptIn(ExperimentalMaterial3Api::class)


package com.github.eeriefoods.pizzabrei.presentation.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.os.BuildCompat.*
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Screens


@Composable
fun uploadScreen(navController: NavController) {
    PizzaBreiTheme {

        val pickPictureLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) { imageUri ->
            if (imageUri != null) {
                // Update the state with the Uri
            }
        }

        var author by remember {
            mutableStateOf("")
        }
        var appName by remember {
            mutableStateOf("")
        }
        var version by remember {
            mutableStateOf("")
        }
        var description by remember {
            mutableStateOf("")
        }

        var imageUri by remember {
            mutableStateOf<Uri?>(null)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {

            item {
                TextField(
                    value = appName,
                    onValueChange = {
                        appName = it
                    },
                    label = { Text("Name") },
                    placeholder = { Text("App Name") },
                    singleLine = true
                )
            }

            item {
                TextField(
                    value = author,
                    onValueChange = {
                        author = it
                    },
                    label = { Text("Author") },
                    placeholder = { Text("Author 1, Author 2, ...") }
                )
            }

            item {
                TextField(
                    value = version,
                    onValueChange = {
                        version = it
                    },
                    label = { Text("Version") },
                    placeholder = { Text("0.3.9") },
                    singleLine = true
                )
            }


            item {
                TextField(
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    label = { Text("Beschreibung") }
                )
            }

            //PhotoPickerExample()

            item {
                Button(onClick = {
                    pickPictureLauncher.launch("image/*")
                }) {
                    Text("Image Picker!")
                }
            }

            item {
                Button(onClick = {
                    pickPictureLauncher.launch("downloads/*")
                }) {
                    Text("File Picker!")
                }
            }

            item {
                Button(onClick = {
                    navController.navigate(Screens.Home.route)
                }) {
                    Text("GO BACK!!!!!")
                }
            }
        }

    }

}

