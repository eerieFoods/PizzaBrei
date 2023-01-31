package com.github.eeriefoods.pizzabreiserver.apppackage.api

class AppPackageFileAlreadyExistsException : RuntimeException {

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

}