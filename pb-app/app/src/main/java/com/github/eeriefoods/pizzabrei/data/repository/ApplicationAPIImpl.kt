package com.github.eeriefoods.pizzabrei.data.repository

import android.util.Log
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class ApplicationAPIImpl : ApplicationDataSource {
    private var applicationService = Retrofit.Builder()
        .baseUrl("http://192.168.178.42:8080/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApplicationService::class.java)
    override suspend fun getApplications(): Response<List<ApplicationApiEntity>> = applicationService.getApplications().awaitResponse()

    override suspend fun putApplication(application: Application): Response<ApplicationApiEntity> {
        Log.d("API", application.toString())
        return applicationService.postApplication(application.applicationApi()).awaitResponse()
    }
}



//TODO ADD BACKEND API CALLS//


interface ApplicationService {
    @GET("application/all")
    fun getApplications(): Call<List<ApplicationApiEntity>>

    @POST("application")
    fun postApplication(@Body application: ApplicationApiEntity): Call<ApplicationApiEntity>

}
