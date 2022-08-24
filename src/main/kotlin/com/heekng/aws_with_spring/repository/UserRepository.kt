package com.heekng.aws_with_spring.repository

import com.heekng.aws_with_spring.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?

    fun findByPhone(phone: String): User?

}