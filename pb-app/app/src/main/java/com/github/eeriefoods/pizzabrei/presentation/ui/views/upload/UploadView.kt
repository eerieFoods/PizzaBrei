package com.github.eeriefoods.pizzabrei.presentation.ui.views.upload

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme


@ExperimentalMaterial3Api
@Composable
fun UploadView(navController: NavController) {
    PizzaBreiTheme {
        Box{
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                item { ShowTextFields() }

                item {ShowButtons(navController)}

                item {

                }
            }
        }

    }
}

 @ExperimentalMaterial3Api
 @Composable
 private fun ShowTextFields(){
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

     Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
         TextField(
             value = appName,
             onValueChange = {
                 appName = it
             },
             label = { Text("Name") },
             placeholder = { Text("App Name") },
             singleLine = true
         )
         TextField(
             value = author,
             onValueChange = {
                 author = it
             },
             label = { Text("Author") },
             placeholder = { Text("Author 1, Author 2, ...") }
         )
         TextField(
             value = version,
             onValueChange = {
                 version = it
             },
             label = { Text("Version") },
             placeholder = { Text("0.3.9") },
             singleLine = true
         )
         TextField(
             value = description,
             onValueChange = {
                 description = it
             },
             label = { Text("Beschreibung") }
         )
     }
 }

@Composable
fun ShowButtons(navController: NavController) {
    val pickPictureLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { imageUri ->
        if (imageUri != null) {
            // Update the state with the Uri
            println(imageUri)
        }
    }
    Column {
        LazyRow {
            item {
                Button(onClick = {
                    pickPictureLauncher.launch("image/*")
                }, Modifier.padding(8.dp)) {
                    Text("Image Picker!")
                }
            }

            item {
                Button(onClick = {
                    pickPictureLauncher.launch("application/vnd.android.package-archive")
                }, Modifier.padding(8.dp)) {
                    Text("Select APK")
                }
            }
        }
        Button(onClick = {
            navController.navigateUp()
        },
            Modifier.align(Alignment.CenterHorizontally)) {
            Text("Upload App")
        }
    }
}
