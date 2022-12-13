package com.github.eeriefoods.pizzabreiserver.review.service

import com.github.eeriefoods.pizzabreiserver.review.domain.Review
import com.github.eeriefoods.pizzabreiserver.review.repository.ReviewRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReviewService(val reviewRepository: ReviewRepository) {

    fun getReviewsByApplicationId(appId: String): List<Review> {
        return reviewRepository.getAllByApplicationAppID(appId)
    }

    fun createReview(review: Review): Review {
        review.reviewID = UUID.randomUUID().toString()

        return reviewRepository.save(review)
    }

    // TODO: Is this function necessary?
    fun updateReview(newReview: Review): Review {
        val review = reviewRepository.findById(newReview.reviewID!!).orElseThrow()

        review.content = newReview.content
        review.rating = newReview.rating

        return reviewRepository.save(review)
    }

    fun deleteReview(reviewId: String) {
        reviewRepository.deleteById(reviewId)
    }

}