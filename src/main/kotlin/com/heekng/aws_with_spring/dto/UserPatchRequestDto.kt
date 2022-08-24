package com.heekng.aws_with_spring.dto

data class UserPatchRequestDto(
    val name: String? = null,
    val phone: String? = null,
) {

}
