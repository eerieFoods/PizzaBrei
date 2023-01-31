package com.github.eeriefoods.pizzabrei.domain.repository

import com.github.eeriefoods.pizzabrei.domain.model.Review

interface ReviewRepository {
    suspend fun getReviews(): List<Review>
    suspend fun putReview(review: Review)
}