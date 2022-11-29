package com.github.eeriefoods.pizzabreiserver.application.api

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ApplicationData(
    @field:NotBlank
    var name: String,
    @field:NotNull
    var fileUrl: String,
    @field:NotNull
    var version: String
) {

    var appId: String? = null
    var description: String? = null
    var authors: String? = null
    var creationDate: LocalDateTime? = null
    var downloadCount: Int? = null

}