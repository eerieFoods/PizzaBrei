package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.domain.usecases.GetApplications
import com.github.eeriefoods.pizzabrei.domain.usecases.GetReviews
import com.github.eeriefoods.pizzabrei.domain.usecases.PutApplication
import com.github.eeriefoods.pizzabrei.domain.usecases.PutReview
import com.github.eeriefoods.pizzabrei.domain.model.Application as App
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val getApplicationsUseCase: GetApplications,
    private val getReviewsUseCase: GetReviews,
    private val putApplicationUseCase: PutApplication,
    private val putReviewUseCase: PutReview
    ) : ViewModel() {
    private val _applications = mutableStateListOf<App>()
    private val _uploadApp = mutableStateListOf<App>()
    private val _recomendedApps = mutableStateListOf<App>()
    private val _reviews = mutableStateListOf<Review>()
    private val _uploadReview = mutableStateListOf<Review>()

    val applications: List<App>
        get() = _applications

    val reviews: List<Review>
        get() = _reviews
    val uploadApp: App
        get() = _uploadApp[0]
    val uploadReview: Review
        get() = _uploadReview[0]
    val recommendedApp: App
        get() {
            if (_recomendedApps.isEmpty()){return Application()
            }
            return _recomendedApps[0]
        }

    lateinit var selectedApp: App

    suspend fun getApplications(){
        viewModelScope.launch {
            _applications.removeAll(_applications)
            _applications.addAll(getApplicationsUseCase())
        }
    }

    suspend fun getReviews(){
        viewModelScope.launch {
            _reviews.removeAll(_reviews)
            _reviews.addAll(getReviewsUseCase())
        }
    }

    suspend fun putApplication(application: App) {
        viewModelScope.launch{
            _uploadApp.add(putApplicationUseCase(application))
        }
    }
    suspend fun putReview(review: Review){
        viewModelScope.launch {
            _uploadReview.add(putReviewUseCase(review))
        }
    }
    suspend fun getRandomApp(){
        viewModelScope.launch {
            _recomendedApps.removeAll(_recomendedApps)
            _recomendedApps.add(_applications.random())
        }
    }
}