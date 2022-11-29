package com.github.eeriefoods.pizzabreiserver.application.service

import com.github.eeriefoods.pizzabreiserver.application.domain.Application
import com.github.eeriefoods.pizzabreiserver.application.repository.ApplicationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ApplicationService constructor(val applicationRepository: ApplicationRepository) {

    fun getAllApplications(): List<Application> {
        return applicationRepository.findAll()
    }

    fun getApplication(id: String): Application {
        return applicationRepository.findById(id).orElseThrow()
    }

    fun createApplication(application: Application): Application {
        application.downloadCount = 0
        application.creationDate = LocalDateTime.now()
        application.appID = UUID.randomUUID().toString()

        return applicationRepository.save(application)
    }

    fun updateApplication(newApplication: Application): Application {
        val app = applicationRepository.findById(newApplication.appID!!).orElseThrow()

        app.name = newApplication.name
        app.fileUrl = newApplication.fileUrl
        app.description = newApplication.version
        app.authors = newApplication.authors
        app.version = newApplication.version

        return applicationRepository.save(app)
    }

    fun incrementDownloadCount(id: String): Application {
        val app = applicationRepository.findById(id).orElseThrow()

        app.downloadCount = app.downloadCount?.plus(1)

        return applicationRepository.save(app)
    }

    fun deleteApplication(id: String) {
        applicationRepository.deleteById(id)
    }

}