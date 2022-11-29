package com.github.eeriefoods.pizzabreiserver.application.api

import com.github.eeriefoods.pizzabreiserver.application.domain.ApplicationFactory
import com.github.eeriefoods.pizzabreiserver.application.service.ApplicationService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("application")
class ApplicationController(
    val applicationDataFactory: ApplicationDataFactory,
    val applicationService: ApplicationService,
    val applicationFactory: ApplicationFactory) {

    @GetMapping("/all", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllApplications(): List<ApplicationData> {
        return applicationDataFactory.from(applicationService.getAllApplications())
    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getApplication(@PathVariable("id") uuid: String): ApplicationData? {
        return applicationDataFactory.from(applicationService.getApplication(uuid))
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createApplication(@RequestBody @Valid application: ApplicationData): ResponseEntity<ApplicationData> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(applicationDataFactory.from(applicationService.createApplication(applicationFactory.from(application))))
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateApplication(@RequestBody @Valid application: ApplicationData): ResponseEntity<ApplicationData> {
        return ResponseEntity
            .ok(applicationDataFactory.from(applicationService.updateApplication(applicationFactory.from(application))))
    }

    @PutMapping("{id}/increment", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun incrementDownloadCount(@PathVariable id: String): ApplicationData {
        return applicationDataFactory.from(applicationService.incrementDownloadCount(id))
    }

    @DeleteMapping("{id}")
    fun deleteApplication(@PathVariable id: String) {
        applicationService.deleteApplication(id)
    }
}