package com.github.eeriefoods.pizzabrei.domain.model

data class ApplicationApiEntity(
    val appId: String?,
    val name: String?,
    val fileUrl: String?,
    val description: String? = null,
    var authors: String? = null,
    val creationDate: String? = null,
    val downloadCount: Int? = null,
    val version: String? = null,
    val reviews: List<Review>? = null
) {
    fun application(): Application {
        return Application(
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
