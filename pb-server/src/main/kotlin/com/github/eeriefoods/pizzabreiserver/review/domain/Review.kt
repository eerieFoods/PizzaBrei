package com.github.eeriefoods.pizzabreiserver.review.domain

import com.github.eeriefoods.pizzabreiserver.application.domain.Application
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "PB_REVIEW")
open class Review(
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    open val application: Application? = null
) {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    open var reviewID: String? = null;

    @Column(name = "content", nullable = false)
    open var content: String? = null

    @Column(name = "author", nullable = false)
    open var author: String? = null

    @Column(name = "rating", nullable = false)
    open var rating: Int? = null

}