package com.heekng.aws_with_spring.service

import com.heekng.aws_with_spring.dto.UserCreateRequestDto
import com.heekng.aws_with_spring.dto.UserPatchRequestDto
import com.heekng.aws_with_spring.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun save(
        request: UserCreateRequestDto,
    ): Long {
        val savedUser = userRepository.save(request.toEntity())
        return savedUser.id!!
    }

    @Transactional
    fun update(
        id: Long,
        request: UserPatchRequestDto,
    ): Boolean {
        val user = userRepository.findByIdOrNull(id) ?: return false
        user.update(
            name = request.name,
            phone = request.phone
        )
        return true
    }
}