package com.github.eeriefoods.pizzabreiserver.application.api

import com.github.eeriefoods.pizzabreiserver.application.service.ApplicationService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("application")
class ApplicationController(val applicationDataFactory: ApplicationDataFactory, val applicationService: ApplicationService) {

    @GetMapping("/all", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllApplications(): List<ApplicationData> {
        return applicationDataFactory.from(applicationService.getAllApplications())
    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getApplication(@PathVariable("id") uuid: String): ApplicationData {
        return applicationDataFactory.from(applicationService.get)
    }

}