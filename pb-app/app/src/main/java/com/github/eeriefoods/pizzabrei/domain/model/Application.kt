package com.github.eeriefoods.pizzabrei.domain.model

import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDateTime

data class Application(
    val appID: String,
    val name: String,
    val fileURL: String,
    val description: String? = null,
    var authors: String? = null,
    val creationDate: LocalDateTime? = null,
    val downloadCount: Int? = null,
    val version: String? = null,
    val ratings: List<Review>? = null,
    val images: List<Painter>? = null
)