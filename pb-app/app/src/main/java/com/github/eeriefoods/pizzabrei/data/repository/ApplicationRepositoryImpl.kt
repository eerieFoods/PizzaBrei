package com.github.eeriefoods.pizzabrei.data.repository

import androidx.activity.ComponentActivity
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity
import com.github.eeriefoods.pizzabrei.domain.repository.ApplicationRepository
import retrofit2.Response

class ApplicationRepositoryImpl(private val dataSource: ApplicationDataSource): ApplicationRepository {
    override suspend fun getApplications(): List<ApplicationApiEntity>? {
        return dataSource.getApplications().body()
    }

    override suspend fun putApplication(application: Application, activity: ComponentActivity): Response<ApplicationApiEntity> {
        return dataSource.putApplication(application, activity)
    }
}