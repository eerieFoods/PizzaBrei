package com.github.eeriefoods.pizzabreiserver.application.domain

import com.github.eeriefoods.pizzabreiserver.application.api.ApplicationData
import org.springframework.stereotype.Component

@Component
class ApplicationFactory {

    fun from(data: ApplicationData): Application {
        val app =  Application()
        app.appID = data.appId
        app.name = data.name
        app.description = data.description
        app.authors = data.authors
        app.fileUrl = data.fileUrl
        app.creationDate = data.creationDate
        app.downloadCount = data.downloadCount
        app.version = data.version

        return app
    }

}