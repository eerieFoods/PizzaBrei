package com.github.eeriefoods.pizzabreiserver.shared.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "ftp")
@ConstructorBinding
data class FtpProperties(
    val username: String?,
    val password: String?,
    val address: String?,
    val directory: String?
)