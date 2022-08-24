package com.heekng.aws_with_spring.dto

import com.heekng.aws_with_spring.entity.User

data class UserCreateRequestDto(
    val name: String,
    val phone: String,
) {

    fun toEntity(): User {
        return User(
            name = name,
            phone = phone,
        )
    }

}
