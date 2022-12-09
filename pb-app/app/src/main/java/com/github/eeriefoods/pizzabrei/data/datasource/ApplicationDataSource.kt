package com.github.eeriefoods.pizzabrei.data.datasource

import com.github.eeriefoods.pizzabrei.domain.model.Application

interface ApplicationDataSource {
    suspend fun getApplications(): List<Application>
    suspend fun putApplication(application: Application)
}