package com.heekng.springwithaws.dto

import com.heekng.springwithaws.entity.User

data class UserPatchRequestDto(
    val name: String? = null,
    val phone: String? = null,
) {

}
