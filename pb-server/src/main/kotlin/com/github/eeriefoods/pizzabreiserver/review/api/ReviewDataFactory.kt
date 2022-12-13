package com.github.eeriefoods.pizzabreiserver.review.api

import com.github.eeriefoods.pizzabreiserver.review.domain.Review
import org.springframework.stereotype.Component

@Component
class ReviewDataFactory {

    fun from(review: Review): ReviewData {
        val reviewData = ReviewData(
            review.content!!,
            review.author!!,
            review.rating!!,
            review.application?.appID!!)

        reviewData.reviewId = review.reviewID

        return reviewData
    }

    fun from(reviews: List<Review>): List<ReviewData> {
        return reviews.stream()
            .map(this::from)
            .toList()
    }

}