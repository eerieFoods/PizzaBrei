package com.github.eeriefoods.pizzabrei.presentation.ui.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.domain.usecases.GetApplications
import com.github.eeriefoods.pizzabrei.domain.usecases.GetReviews
import com.github.eeriefoods.pizzabrei.domain.model.Application as App
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val getApplicationsUseCase: GetApplications,
    private val getReviewsUseCase: GetReviews
) : ViewModel() {
    private val _applications = mutableStateListOf<App>()
    private val _reviews = mutableStateListOf<Review>()

    val applications: List<App>
        get() = _applications
    val reviews: List<Review>
        get() = _reviews

    suspend fun getApplications(){
        viewModelScope.launch {
            _applications.addAll(getApplicationsUseCase())
            _reviews.addAll(getReviewsUseCase())
        }
    }
}

//class HomeViewModel(
//    application: Application,
//    private val repository: AppRepository
//) : AndroidViewModel(application) {
//    var uiState by mutableStateOf(HomeUiState())
//        private set
//    init {
//        viewModelScope.launch {
//            uiState = HomeUiState(
//                repository.getAppData()
//            )
//        }
//    }
//
//    companion object {
//        fun provideFactory(
//            application: Application,
//            repository: AppRepository
//        ): ViewModelProvider.AndroidViewModelFactory {
//            return object : ViewModelProvider.AndroidViewModelFactory(application) {
//                @Suppress("unchecked_cast")
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    return HomeViewModel(application, repository) as T
//                }
//            }
//        }
//    }
//}

//data class HomeUiState (
//    var applicationList: List<App> = emptyList()
//)