package com.github.eeriefoods.pizzabrei.data.datasource

import androidx.activity.ComponentActivity
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity
import retrofit2.Response

interface ApplicationDataSource {
    suspend fun getApplications(): Response<List<ApplicationApiEntity>>
    suspend fun putApplication(application: Application, activity: ComponentActivity): Response<ApplicationApiEntity>
}