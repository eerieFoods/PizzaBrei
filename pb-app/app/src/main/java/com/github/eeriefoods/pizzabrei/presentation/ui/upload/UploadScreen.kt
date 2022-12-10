 @file:OptIn(ExperimentalMaterial3Api::class)


package com.github.eeriefoods.pizzabrei.presentation.ui.screens

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.BuildCompat
import androidx.core.os.BuildCompat.*
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Screens
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.google.modernstorage.photopicker.PhotoPicker
import java.lang.reflect.Modifier


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

        Column() {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Name")
                TextField(
                    value = appName,
                    onValueChange = {
                        appName = it
                    })
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Author")
                TextField(
                    value = author,
                    onValueChange = {
                        author = it
                    })
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(text = "Version")
                TextField(
                    value = version,
                    onValueChange = {
                        version = it
                    })
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(text = "Beschreibung")
                TextField(
                    value = description,
                    onValueChange = {
                        description = it
                    })
            }

            //PhotoPickerExample()

            Button(onClick = {
                pickPictureLauncher.launch("image/*")
            }) {
                Text("Image Picker!")
            }

            Button(onClick = {
                pickPictureLauncher.launch("downloads/*")
            }) {
                Text("File Picker!")
            }

            Button(onClick = {
                navController.navigate(Screens.Home.route)
            }) {
                Text("GO BACK!!!!!")
            }


        }

    }

}

