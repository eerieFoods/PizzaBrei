package com.github.eeriefoods.pizzabrei.domain.model

import java.time.LocalDateTime

data class ApplicationApiEntity(
    val appID: String,
    val name: String,
    val fileURL: String,
    val description: String? = null,
    var authors: String? = null,
    val creationDate: LocalDateTime? = null,
    val downloadCount: Int? = null,
    val version: String? = null,
    val ratings: List<Review>? = null
){
    fun ApplicationApiEntity.application(): Application {
        return Application(
            appID = appID,
            name = name,
            fileURL = fileURL,
            description = description,
            authors = authors,
            creationDate = creationDate,
            downloadCount = downloadCount,
            version = version,
            ratings = ratings
        )
    }
}
