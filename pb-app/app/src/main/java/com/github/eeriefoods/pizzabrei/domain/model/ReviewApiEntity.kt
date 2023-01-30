package com.github.eeriefoods.pizzabrei.domain.model

data class ReviewApiEntity(
    val appID: String,
    val reviewID: String,
    val content: String,
    val author: String,
    val rating: Int
){
    fun ReviewApiEntity.review(): Review {
        return Review(
            appID = appID,
            reviewID = reviewID,
            content = content,
            author = author,
            rating = rating
        )
    }
}
