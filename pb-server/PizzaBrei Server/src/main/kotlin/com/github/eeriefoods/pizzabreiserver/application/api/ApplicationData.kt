package com.github.eeriefoods.pizzabreiserver.application.api

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ApplicationData(
    @field:NotBlank
    var appId: String,
    @field:NotBlank
    var name: String,
    var description: String,
    var authors: String,
    @field:NotNull
    var fileUrl: String,
    var creationDate: LocalDateTime,
    var downloadCount: Int,
    var version: String
    ) {
}