package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.*
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
    ) : ViewModel() {
    private val _applications = mutableStateListOf<App>()
    private val _recommendedApp = mutableStateOf(App())
    private val _reviews = mutableStateListOf<Review>()
    var searchText = mutableStateOf("")
    val focusRequester = FocusRequester()

    val applications: List<App>
        get() = _applications

    val reviews: List<Review>
        get() = _reviews

    var recommendedApp: App = App()
        get() = _recommendedApp.value
    val filteredApps: List<App>
        get() {
            if(applications.isEmpty()){return  applications }
            return applications.filter {
                it.name!!.contains(searchText.value, ignoreCase = true)}
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


}