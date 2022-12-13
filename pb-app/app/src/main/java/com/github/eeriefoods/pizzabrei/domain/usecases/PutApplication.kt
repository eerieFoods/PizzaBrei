package com.github.eeriefoods.pizzabrei.domain.usecases

import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.repository.ApplicationRepository

class PutApplication(
    private val repository: ApplicationRepository
){
    suspend operator fun invoke(application: Application): Application {
        repository.putApplication(application)
        return application
    }
}
