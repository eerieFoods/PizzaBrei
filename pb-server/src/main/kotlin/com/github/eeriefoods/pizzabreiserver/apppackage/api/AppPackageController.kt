package com.github.eeriefoods.pizzabreiserver.apppackage.api

import com.github.eeriefoods.pizzabreiserver.apppackage.service.AppPackageService
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("apk")
class AppPackageController(
    val appPackageService: AppPackageService
) {

    @GetMapping("{appId}")
    fun downloadAppPackage(@PathVariable appId: String): ResponseEntity<Resource> {
        val file = appPackageService.load(appId)
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"${file.filename}\"").body(file)
    }

    @PostMapping("{appId}")
    fun uploadAppPackage(@RequestParam("file") file: MultipartFile, @PathVariable appId: String): String {
        return try {
            appPackageService.storeFile(file, appId);
        } catch (e: Exception) {
            e.message ?: e.localizedMessage
        }
    }

}