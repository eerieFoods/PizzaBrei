package com.github.eeriefoods.pizzabrei.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class Application(
    val appID: String? = null,
    val name: String? = null,
    val fileURL: String? = null,
    val description: String? = null,
    var authors: String? = null,
    val creationDate: String? = null,
    val downloadCount: Int? = null,
    val version: String? = null,
    val ratings: List<Review>? = null,
    val images: List<Painter>? = null
)