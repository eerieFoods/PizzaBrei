package com.github.eeriefoods.pizzabreiserver.review.domain

import com.github.eeriefoods.pizzabreiserver.application.service.ApplicationService
import com.github.eeriefoods.pizzabreiserver.review.api.ReviewData
import org.springframework.stereotype.Component

@Component
class ReviewFactory(val applicationService: ApplicationService) {

    fun from(reviewData: ReviewData): Review {
        val review = Review(applicationService.getApplication(reviewData.appId))
        review.reviewID = reviewData.reviewId
        review.content = reviewData.content
        review.rating = reviewData.rating
        review.author = reviewData.author

        return review
    }

}