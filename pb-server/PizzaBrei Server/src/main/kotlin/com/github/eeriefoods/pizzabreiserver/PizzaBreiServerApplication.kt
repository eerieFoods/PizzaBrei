package com.github.eeriefoods.pizzabreiserver

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
    info = Info(
        title = "PizzaBrei",
        description = "Backand für Mobile Applikationen Vorlesung",
        version = "v1",
        contact = Contact(
            url = "https://github.com/eerieFoods",
            name = "eerieFoods"
        ),
        license = License(
            name = "GNU General Public License v3.0",
            url = "https://www.gnu.de/documents/gpl-3.0.en.html"
        )
    )
)
@SpringBootApplication
class PizzaBreiServerApplication

fun main(args: Array<String>) {
    runApplication<PizzaBreiServerApplication>(*args)
}
