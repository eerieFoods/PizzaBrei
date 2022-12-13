package com.github.eeriefoods.pizzabrei.domain.model

data class Review(
    val appID: String,
    val reviewID: String,
    val content: String,
    val author: String,
    val rating: Int
)
