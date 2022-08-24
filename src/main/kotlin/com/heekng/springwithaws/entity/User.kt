package com.heekng.springwithaws.entity

import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    val id: Long? = null,
    val name: String,
    val phone: String,
) {
}