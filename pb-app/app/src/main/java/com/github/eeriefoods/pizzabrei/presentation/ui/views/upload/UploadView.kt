package com.github.eeriefoods.pizzabrei.presentation.ui.views.upload

import android.util.Log
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
import com.github.eeriefoods.pizzabrei.domain.model.Application
import coil.compose.AsyncImage
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.UUID


@ExperimentalMaterial3Api
@Composable
fun UploadView(navController: NavController) {
    val uploadViewModel = UploadViewModel()

    PizzaBreiTheme {
        Box{
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                item { ShowTextFields(uploadViewModel) }

                item {ShowButtons(navController, uploadViewModel)}

                item {

                }
            }
        }

    }
}

 @ExperimentalMaterial3Api
 @Composable
 private fun ShowTextFields(view: UploadViewModel){

     Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
         TextField(
             value = view.name.value,
             onValueChange = {
                 view.name.value = it
             },
             label = { Text("Name") },
             placeholder = { Text("App Name") },
             singleLine = true
         )
         TextField(
             value = view.author.value,
             onValueChange = {
                 view.author.value = it
             },
             label = { Text("Author") },
             placeholder = { Text("Author 1, Author 2, ...") }
         )
         TextField(
             value = view.version.value,
             onValueChange = {
                 view.version.value = it
             },
             label = { Text("Version") },
             placeholder = { Text("0.3.9") },
             singleLine = true
         )
         TextField(
             value = view.description.value,
             onValueChange = {
                 view.description.value = it
             },
             label = { Text("Beschreibung") }
         )
     }
 }

@Composable
fun ShowButtons(navController: NavController, view: UploadViewModel) {

    val pickPictureLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        view.hasImage.value = it != null
        view.imageUri.value = it
        Log.d("Api", it.toString())
    }

    val apkSelectLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        view.hasApk.value = it != null
        view.apkUri.value = it
        Log.d("Api", it.toString())
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
            val app = Application(appId = UUID.randomUUID().toString(), name = view.name.value, description = view.description.value, authors = view.author.value, version = view.version.value, fileUrl = view.apkUri.value)
            putApp(app, view)
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
private fun putApp(application: Application, viewModel: UploadViewModel) = runBlocking {
    launch {
        viewModel.putApplication(application)
    }
}