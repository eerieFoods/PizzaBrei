package com.github.eeriefoods.pizzabrei.data.repository

import android.util.Log
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application

class ApplicationAPIImpl : ApplicationDataSource {

    override suspend fun getApplications(): List<Application> {
//        return ApplicatinoApi.getInstance().getApplications()
        return listOf(
            Application("1","Pizza Brei","url", "Lorem ipsum dolor sit amet","Team EerieFoods", version = "0.1.alpha"),
            Application("2","Klempner Brüder Party","url", "Lorem ipsum dolor sit amet","Mimtendo", version = "0.2.alpha"),
            Application("3","Brutus der Igel","url", "Lorem ipsum dolor sit amet","Mega", version = "0.3.alpha"),
            Application("4","FUBA","url", "Lorem ipsum dolor sit amet","AE Sport", version = "0.4.alpha"),
            Application("5","Gott des Pazifismus","url", "Lorem ipsum dolor sit amet","Sona", version = "1.0.beta"),
            Application("6","Buddelbauen","url", "Lorem ipsum dolor sit amet","Mincrosoft", version = "1.1.beta"),
            Application("7","Gaaglo","url", "Lorem ipsum dolor sit amet","Gaaglo", version = "1.2.beta"),
            Application("8","GesichtsBuch","url", "Lorem ipsum dolor sit amet","Mate", version = "1.3.beta"))
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