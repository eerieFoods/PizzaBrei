package com.github.eeriefoods.pizzabreiserver.apppackage.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartException
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@RestController
@RequestMapping("apk")
class AppPackageController {

    @PostMapping
    fun uploadAppPackage(@RequestParam("file") file: MultipartFile,
                         redirectAttributes: RedirectAttributes): String {
        // storageService.store
        redirectAttributes.addFlashAttribute("message"
            , "You successfully uploaded ${file.originalFilename}!")

        return "redirect:/";
    }

}