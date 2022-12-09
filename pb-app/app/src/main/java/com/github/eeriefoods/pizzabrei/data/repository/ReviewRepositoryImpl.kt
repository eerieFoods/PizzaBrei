package com.github.eeriefoods.pizzabrei.data.repository

import com.github.eeriefoods.pizzabrei.data.datasource.ReviewDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.domain.repository.ReviewRepository

class ReviewRepositoryImpl(private val dataSource: ReviewDataSource): ReviewRepository {
    override suspend fun getReviews(): List<Review> {
        return dataSource.getReviews()
    }
}