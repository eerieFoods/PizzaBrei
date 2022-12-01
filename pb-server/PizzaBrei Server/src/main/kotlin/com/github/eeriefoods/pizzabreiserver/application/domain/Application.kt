package com.github.eeriefoods.pizzabreiserver.application.domain

import com.github.eeriefoods.pizzabreiserver.review.domain.Review
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "PB_APPLICATION")
open class Application {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    open var appID: String? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "description")
    open var description: String? = null

    @Column(name = "authors")
    open var authors: String? = null

    @Column(name = "file_url", nullable = false)
    open var fileUrl: String? = null

    // TODO: Pictures

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null;

    @Column(name = "download_count", nullable = false)
    open var downloadCount: Int? = 0

    @Column(name = "version", nullable = false)
    open var version: String? = null

    @Column(name = "ratings")
    @OneToMany(cascade = [CascadeType.ALL])
    open var ratings: MutableList<Review>? = null

}