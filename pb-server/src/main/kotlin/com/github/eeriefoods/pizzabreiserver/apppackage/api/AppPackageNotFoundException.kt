package com.github.eeriefoods.pizzabreiserver.apppackage.api

class AppPackageNotFoundException : RuntimeException {

    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)

}