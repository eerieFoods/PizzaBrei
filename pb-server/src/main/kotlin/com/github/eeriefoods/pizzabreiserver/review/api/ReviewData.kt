package com.github.eeriefoods.pizzabreiserver.review.api

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ReviewData(
    @field:NotBlank
    var content: String,
    @field:NotBlank
    var author: String,
    @field:NotNull
    @field:Max(5)
    @field:Min(1)
    var rating: Int,
    @field:NotBlank
    var appId: String
) {

    var reviewId: String? = null

}