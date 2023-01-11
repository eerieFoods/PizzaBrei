package com.github.eeriefoods.pizzabrei.data.repository

import android.util.Log
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApplicationAPIImpl : ApplicationDataSource {
    var service = Retrofit.Builder()
        .baseUrl("http://192.168.178.21:8080/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApplicationService::class.java)
    override suspend fun getApplications(): Response<List<ApplicationApiEntity>> = service.getApplications().awaitResponse()
    override suspend fun putApplication(application: Application) {
        Log.d("API",application.toString())
    }
}



//TODO ADD BACKEND API CALLS//


interface ApplicationService {
    @GET("application/all")
    fun getApplications(): Call<List<ApplicationApiEntity>>

}