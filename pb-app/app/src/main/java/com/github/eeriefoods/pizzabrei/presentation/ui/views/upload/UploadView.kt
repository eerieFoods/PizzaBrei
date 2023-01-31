package com.github.eeriefoods.pizzabrei.presentation.ui.views.upload

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme


@ExperimentalMaterial3Api
@Composable
fun UploadView(navController: NavController) {
    val model = UploadViewModel()

    PizzaBreiTheme {
        Box{
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                item { ShowTextFields(model) }

                item {ShowButtons(navController, model)}

                item {

                }
            }
        }

    }
}

 @ExperimentalMaterial3Api
 @Composable
 private fun ShowTextFields(viewModel: UploadViewModel){

     Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
         TextField(
             value = viewModel.appName.value,
             onValueChange = {
                 viewModel.appName.value = it
             },
             label = { Text("Name") },
             placeholder = { Text("App Name") },
             singleLine = true
         )
         TextField(
             value = viewModel.author.value,
             onValueChange = {
                 viewModel.author.value = it
             },
             label = { Text("Author") },
             placeholder = { Text("Author 1, Author 2, ...") }
         )
         TextField(
             value = viewModel.version.value,
             onValueChange = {
                 viewModel.version.value = it
             },
             label = { Text("Version") },
             placeholder = { Text("0.3.9") },
             singleLine = true
         )
         TextField(
             value = viewModel.description.value,
             onValueChange = {
                 viewModel.description.value = it
             },
             label = { Text("Beschreibung") }
         )
     }
 }

@Composable
fun ShowButtons(navController: NavController, viewModel: UploadViewModel) {

    val pickPictureLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        viewModel.hasImage.value = it != null
        viewModel.imageUri.value = it
    }

    val apkSelectLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        viewModel.hasApk.value = it != null
        viewModel.apkUri.value = it
    }

    Column {
        LazyRow {
            item {
                Button(onClick = {
                    pickPictureLauncher.launch("image/*")
                }, Modifier.padding(8.dp)) {
                    Text("Bild auswählen")
                }
            }

            item {
                Button(onClick = {
                    apkSelectLauncher.launch("application/vnd.android.package-archive")
                }, Modifier.padding(8.dp)) {
                    Text("APK Auswählen")
                }
            }
        }
        Button(onClick = {
            navController.navigateUp()
        },
            Modifier.align(Alignment.CenterHorizontally)) {
            Text("App Hochladen")
        }

        if (viewModel.hasImage.value) {
            AsyncImage(model = viewModel.imageUri.value, contentDescription = "Ausgewähltes Bild", modifier = Modifier.fillMaxWidth())
        }
    }
}
