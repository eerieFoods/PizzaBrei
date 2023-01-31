package com.github.eeriefoods.pizzabrei.presentation.ui.views.upload

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationRepositoryImpl
import com.github.eeriefoods.pizzabrei.data.repository.ReviewAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ReviewRepositoryImpl
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.usecases.PutApplication
import com.github.eeriefoods.pizzabrei.domain.usecases.PutReview
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import kotlinx.coroutines.*
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset
import java.util.*


@ExperimentalMaterial3Api
@Composable
fun UploadView(navController: NavController, activity: ComponentActivity) {
    val uploadViewModel = UploadViewModel(
        putApplicationUseCase = PutApplication(
            repository = ApplicationRepositoryImpl(
                dataSource = ApplicationAPIImpl()
            )
        ),
        putReviewUseCase = PutReview(
            repository = ReviewRepositoryImpl(
                dataSource = ReviewAPIImpl()
            )
        )
    )

    PizzaBreiTheme {
        Box{
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                item { ShowTextFields(uploadViewModel) }

                item {ShowButtons(navController, uploadViewModel, activity)}

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
fun ShowButtons(navController: NavController, viewModel: UploadViewModel, activity: ComponentActivity) {

    val path: File = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DOWNLOADS
    )
    val file: File = File(path, "YouTube_18.04.35_Apkpure.apk")

    val pickPictureLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        viewModel.hasImage.value = it != null
        viewModel.imageUri.value = it
        Log.d("Api", it.toString())
    }

    val apkSelectLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        activity.lifecycleScope.launch(){
            viewModel.hasApk.value = it != null
            viewModel.apkUri.value = it
            Log.d("Api", it.toString())
            val data = read(activity.applicationContext, it!!)
        }

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
            val app = Application(appId = UUID.randomUUID().toString(), name = viewModel.name.value, description = viewModel.description.value, authors = viewModel.author.value, version = viewModel.version.value, fileUrl = viewModel.apkUri.value.toString())
            putApp(app, viewModel, activity)
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
private fun putApp(application: Application, viewModel: UploadViewModel, activity: ComponentActivity) = runBlocking {
    launch {
        viewModel.putApplication(application, activity)
    }
}
suspend fun read(context: Context, source: Uri): String = withContext(Dispatchers.IO) {
    val resolver: ContentResolver = context.contentResolver

    resolver.openInputStream(source)?.use { stream -> stream.readText() }
        ?: throw IllegalStateException("could not open $source")
}

private fun InputStream.readText(charset: Charset = Charsets.UTF_8): String = readBytes().toString(charset)