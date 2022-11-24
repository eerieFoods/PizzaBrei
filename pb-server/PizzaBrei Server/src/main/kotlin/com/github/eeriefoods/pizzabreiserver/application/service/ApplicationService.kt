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

}