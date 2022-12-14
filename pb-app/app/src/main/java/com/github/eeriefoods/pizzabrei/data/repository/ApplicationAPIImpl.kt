package com.github.eeriefoods.pizzabrei.data.repository

import android.util.Log
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application

class ApplicationAPIImpl : ApplicationDataSource {

    override suspend fun getApplications(): List<Application> {
//        return ApplicatinoApi.getInstance().getApplications()
        return listOf(
            Application("ID 1","App 1","url", "Desc1","Team EerieFoods", version = "0.1.alpha"),
            Application("ID 2","App 2","url", "Desc2","Nintendo", version = "0.2.alpha"),
            Application("ID 3","App 3","url", "Desc3","Sega", version = "0.3.alpha"),
            Application("ID 4","App 4","url", "Desc4","EA SPORTS", version = "0.4.alpha"),
            Application("ID 5","App 5","url", "Desc5","Sony", version = "1.0.beta"),
            Application("ID 6","App 6","url", "Desc6","Microsoft", version = "1.1.beta"),
            Application("ID 7","App 7","url", "Desc7","Google", version = "1.2.beta"),
            Application("ID 8","App 8","url", "Desc8","Facebook", version = "1.3.beta"))
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