package com.github.eeriefoods.pizzabrei.domain.repository

import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity

interface ApplicationRepository {
    suspend fun getApplications(): List<ApplicationApiEntity>?
    suspend fun putApplication(application: Application)
}