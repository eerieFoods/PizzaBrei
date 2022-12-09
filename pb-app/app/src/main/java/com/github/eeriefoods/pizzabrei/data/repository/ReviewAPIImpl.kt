package com.github.eeriefoods.pizzabrei.data.repository

import com.github.eeriefoods.pizzabrei.data.datasource.ReviewDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Review

class ReviewAPIImpl : ReviewDataSource {

    override suspend fun getReviews(): List<Review> {
//        return ApplicatinoApi.getInstance().getApplications()
        return listOf(Review("a","b","ccc", "dd", 1 ), Review("d","e","ff", "gg", 1))
    }
}



//TODO ADD BACKEND API CALL//

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