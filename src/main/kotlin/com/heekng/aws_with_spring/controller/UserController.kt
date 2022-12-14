package com.heekng.aws_with_spring.controller

import com.heekng.aws_with_spring.dto.UserCreateRequestDto
import com.heekng.aws_with_spring.dto.UserPatchRequestDto
import com.heekng.aws_with_spring.entity.User
import com.heekng.aws_with_spring.repository.UserRepository
import com.heekng.aws_with_spring.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userRepository: UserRepository,
    private val userService: UserService,
) {

    @GetMapping
    fun getList(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable("id") id: Long,
    ): User {
        return userRepository.findByIdOrNull(id)
            ?: throw IllegalStateException("존재하지 않는 ID 입니다.")
    }

    @PostMapping
    fun save(
        @ModelAttribute request: UserCreateRequestDto,
    ): Long {
        return userService.save(request)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PATCH])
    fun update(
        @PathVariable("id") id: Long,
        @ModelAttribute request: UserPatchRequestDto,
    ): String {
        return if (userService.update(id, request)) "ok" else "not Ok"
    }


}