package com.github.eeriefoods.pizzabrei.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class Application(
    val appId: String? = null,
    val name: String? = null,
    val description: String? = null,
    var authors: String? = null,
    val fileUrl: String? = null,
    val creationDate: String? = null,
    val downloadCount: Int? = null,
    val version: String? = null,
    val reviews: List<Review>? = null,
    val images: List<Painter>? = null
){
    fun applicationApi(): ApplicationApiEntity {
        return ApplicationApiEntity(
            appId = appId,
            name = name,
            fileUrl = fileUrl,
            description = description,
            authors = authors,
            creationDate = creationDate,
            downloadCount = downloadCount,
            version = version,
            reviews = reviews

        )
    }
}