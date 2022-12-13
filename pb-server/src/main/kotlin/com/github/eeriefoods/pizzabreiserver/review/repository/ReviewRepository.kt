package com.github.eeriefoods.pizzabreiserver.review.repository

import com.github.eeriefoods.pizzabreiserver.review.domain.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, String> {

    fun getAllByApplicationAppID(appID: String): List<Review>

}