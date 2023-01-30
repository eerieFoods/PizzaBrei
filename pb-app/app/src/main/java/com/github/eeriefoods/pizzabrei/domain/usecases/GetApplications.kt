package com.github.eeriefoods.pizzabrei.domain.usecases

import com.github.eeriefoods.pizzabrei.R
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.repository.ApplicationRepository

class GetApplications (
    private val repository: ApplicationRepository
){
    suspend operator fun invoke(): List<Application>{
        val applications = mutableListOf<Application>()
        repository.getApplications()!!.let{
            for (application in it){
                applications.add(application.application())
            }
            return applications
        }
    }
}