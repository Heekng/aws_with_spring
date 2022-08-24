package com.heekng.aws_with_spring.entity

import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    val id: Long? = null,
    var name: String,
    var phone: String,
) {
    fun update(
        name: String? = null,
        phone: String? = null,
    ) {
        name?.let { this.name = name }
        phone?.let { this.phone = phone }
    }
}