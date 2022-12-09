package com.github.eeriefoods.pizzabrei.domain.usecases

import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.domain.repository.ReviewRepository

class GetReviews (
    private val repository: ReviewRepository
){
    suspend operator fun invoke(): List<Review>{
        return repository.getReviews()
    }
}