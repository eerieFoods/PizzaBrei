package com.github.eeriefoods.pizzabreiserver

import com.github.eeriefoods.pizzabreiserver.shared.config.FtpProperties
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
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
@EnableConfigurationProperties(FtpProperties::class)
class PizzaBreiServerApplication : CommandLineRunner {

//    @Autowired lateinit var prop: FtpProperties

    override fun run(vararg args: String?) {
//        val con: FTPSClient?
//        try {
//            con = FTPSClient(false)
//            con.connect(prop.address, 21)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
    }

}

fun main(args: Array<String>) {
    runApplication<PizzaBreiServerApplication>(*args)
}
