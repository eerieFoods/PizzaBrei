package com.github.eeriefoods.pizzabrei.data.repository

import android.util.Log
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application

class ApplicationAPIImpl : ApplicationDataSource {

    override suspend fun getApplications(): List<Application> {
//        return ApplicatinoApi.getInstance().getApplications()
        return listOf(
            Application(
                "ID 1"
                ,"WhatsApp","url", "Desc"), Application("ID 2","App 2","url", "Desc2"))
    }
    override suspend fun putApplication(application: Application) {
        Log.d("API",application.toString())
    }

}



//TODO ADD BACKEND API CALLS//

//interface ApplicatinoApi {
//
//    @GET("Application")
//    suspend fun getApplications(): List<ApplicationApiEntity>
//
//    companion object {
//        var applicationApi: ApplicatinoApi? = null
//        fun getInstance(): ApplicatinoApi {
//            if (applicationApi == null) {
//                applicationApi = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(ApplicatinoApi::class.java)
//            }
//            return applicationApi!!
//        }
//    }
//}