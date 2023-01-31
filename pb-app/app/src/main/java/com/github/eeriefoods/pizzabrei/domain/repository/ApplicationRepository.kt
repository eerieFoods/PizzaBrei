package com.github.eeriefoods.pizzabrei.domain.repository

import androidx.activity.ComponentActivity
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity
import retrofit2.Response

interface ApplicationRepository {
    suspend fun getApplications(): List<ApplicationApiEntity>?
    suspend fun putApplication(application: Application,activity: ComponentActivity): Response<ApplicationApiEntity>
}