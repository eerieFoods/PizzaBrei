package com.github.eeriefoods.pizzabreiserver.application.api

import com.github.eeriefoods.pizzabreiserver.application.domain.Application
import org.springframework.stereotype.Component

@Component
class ApplicationDataFactory {

    fun from(app: Application): ApplicationData {
        val data = ApplicationData(app.name!!, app.fileUrl!!, app.version!!)
        data.appId = app.appID
        data.description = app.description
        data.authors = app.authors
        data.creationDate = app.creationDate
        data.downloadCount =  app.downloadCount
        return data
    }

    fun from(apps: List<Application>): List<ApplicationData> {
        return apps.stream()
            .map(this::from)
            .toList()
    }

}