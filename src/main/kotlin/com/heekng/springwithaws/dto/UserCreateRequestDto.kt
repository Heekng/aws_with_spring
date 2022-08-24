package com.heekng.springwithaws.dto

import com.heekng.springwithaws.entity.User

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
