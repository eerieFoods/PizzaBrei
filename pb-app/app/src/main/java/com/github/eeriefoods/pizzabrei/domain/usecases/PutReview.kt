package com.github.eeriefoods.pizzabrei.domain.usecases

import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.Review
import com.github.eeriefoods.pizzabrei.domain.repository.ReviewRepository

class PutReview (
    private val repository: ReviewRepository
){
    suspend operator fun invoke(review: Review): Review {
        repository.putReview(review)
        return review
    }
}