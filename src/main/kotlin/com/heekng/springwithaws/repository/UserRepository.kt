package com.heekng.springwithaws.repository

import com.heekng.springwithaws.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?

    fun findByPhone(phone: String): User?

}