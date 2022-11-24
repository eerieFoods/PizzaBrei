package com.github.eeriefoods.pizzabreiserver.application.api

import com.github.eeriefoods.pizzabreiserver.application.domain.Application
import org.springframework.stereotype.Component

@Component
class ApplicationDataFactory {

    fun from(app: Application): ApplicationData {
        return ApplicationData(
            app.appID!!,
            app.name!!,
            app.description!!,
            app.authors!!,
            app.fileUrl!!,
            app.creationDate!!,
            app.downloadCount!!,
            app.version!!
        )
    }

    fun from(apps: List<Application>): List<ApplicationData> {
        return apps.stream()
            .map(this::from)
            .toList()
    }

}