package com.github.eeriefoods.pizzabrei.data.datasource

import com.github.eeriefoods.pizzabrei.domain.model.Review

interface ReviewDataSource {
    suspend fun getReviews(): List<Review>
    suspend fun putReview(review: Review)
}