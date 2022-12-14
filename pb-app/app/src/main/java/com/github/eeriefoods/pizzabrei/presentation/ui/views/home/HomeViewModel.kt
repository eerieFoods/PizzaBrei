package com.github.eeriefoods.pizzabrei.presentation.ui.views.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalConfiguration
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
    private val _reviews = mutableStateListOf<Review>()
    private val _uploadapplication = mutableStateListOf<App>()
    private val _review = mutableStateListOf<Review>()
//    private val _screenHeight = mutableStateListOf<Dp>()

    val applications: List<App>
        get() = _applications
    val recommendedApplication: App
        get(){
            if (_applications.isEmpty()){return Application("404","error: No Connection")}
            return _applications.random()
        }
    val reviews: List<Review>
        get() = _reviews
    val uploadapplication: App
        get() = _uploadapplication[0]
    val review: Review
        get() = _review[0]

//    val sreenHeight: Dp
//        get() = _screenHeight[0]

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
            _uploadapplication.add(putApplicationUseCase(application))
        }
    }
    suspend fun putReview(review: Review){
        viewModelScope.launch {
            _review.add(putReviewUseCase(review))
        }
    }


//    suspend fun getScreenSize(){
//        viewModelScope.launch{
//            val configuration = LocalConfiguration.current
//            _screenWidth.add(configuration.screenWidthDp.dp)
//            _screenHeight.add(configuration.screenHeightDp.dp)
//        }
//    }
}