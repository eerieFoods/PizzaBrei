package com.github.eeriefoods.pizzabreiserver.application.repository

import com.github.eeriefoods.pizzabreiserver.application.domain.Application
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ApplicationRepository : JpaRepository<Application, String> {
}