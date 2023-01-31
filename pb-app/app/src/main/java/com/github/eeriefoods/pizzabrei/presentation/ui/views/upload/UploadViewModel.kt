package com.github.eeriefoods.pizzabrei.presentation.ui.views.upload

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.domain.usecases.PutApplication
import com.github.eeriefoods.pizzabrei.domain.usecases.PutReview
import kotlinx.coroutines.launch


class UploadViewModel constructor(
    private val putApplicationUseCase: PutApplication,
    private val putReviewUseCase: PutReview
) : ViewModel() {
    private val _uploadApp = mutableStateListOf<Application>()
    private val _uploadReview = mutableStateListOf<Review>()
    var name = mutableStateOf("")
    var author = mutableStateOf("")
    var description = mutableStateOf("")
    var version = mutableStateOf("")
    var imageUri = mutableStateOf<String?>(null)
    var apkUri = mutableStateOf<String?>(null)
    var hasImage = mutableStateOf(false)
    var hasApk = mutableStateOf(false)



    suspend fun putApplication(application: Application) {
        viewModelScope.launch{
            _uploadApp.removeAll(_uploadApp)
            _uploadApp.add(putApplicationUseCase(application))
        }
    }
    suspend fun putReview(review: Review){
        viewModelScope.launch {
            _uploadReview.removeAll(_uploadReview)
            _uploadReview.add(putReviewUseCase(review))
        }
    }
}