package com.github.eeriefoods.pizzabrei.domain.repository

import com.github.eeriefoods.pizzabrei.domain.model.Application

interface ApplicationRepository {
    suspend fun getApplications(): List<Application>
}