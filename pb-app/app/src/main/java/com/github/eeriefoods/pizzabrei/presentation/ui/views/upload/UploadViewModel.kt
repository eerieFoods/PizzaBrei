package com.github.eeriefoods.pizzabrei.presentation.ui.views.upload

import android.net.Uri
import androidx.compose.runtime.mutableStateOf

class UploadViewModel {

    var hasImage = mutableStateOf(false)
    var imageUri = mutableStateOf<Uri?>(null)

    var hasApk = mutableStateOf(false)
    var apkUri = mutableStateOf<Uri?>(null)

    var author = mutableStateOf("")
    var appName = mutableStateOf("")
    var version = mutableStateOf("")
    var description = mutableStateOf("")

}