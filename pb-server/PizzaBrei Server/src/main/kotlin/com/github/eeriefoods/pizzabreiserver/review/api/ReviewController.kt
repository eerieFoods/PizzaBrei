package com.github.eeriefoods.pizzabreiserver.review.api

import com.github.eeriefoods.pizzabreiserver.review.domain.ReviewFactory
import com.github.eeriefoods.pizzabreiserver.review.service.ReviewService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("review")
class ReviewController(
    val reviewService: ReviewService,
    val reviewFactory: ReviewFactory,
    val reviewDataFactory: ReviewDataFactory) {

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createReview(@Valid @RequestBody reviewData: ReviewData): ResponseEntity<ReviewData> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(reviewDataFactory.from(reviewService.createReview(reviewFactory.from(reviewData))))
    }

    @DeleteMapping("{id}")
    fun deleteReview(@PathVariable id: String) {
        reviewService.deleteReview(id)
    }

}