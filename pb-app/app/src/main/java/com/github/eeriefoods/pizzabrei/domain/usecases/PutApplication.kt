package com.github.eeriefoods.pizzabrei.domain.usecases

import androidx.activity.ComponentActivity
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.repository.ApplicationRepository

class PutApplication(
    private val repository: ApplicationRepository
){
    suspend operator fun invoke(application: Application, activity: ComponentActivity): Application {
        repository.putApplication(application, activity)
        return application
    }
}
