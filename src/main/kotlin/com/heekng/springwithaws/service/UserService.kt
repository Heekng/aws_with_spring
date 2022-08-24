package com.heekng.springwithaws.service

import com.heekng.springwithaws.dto.UserCreateRequestDto
import com.heekng.springwithaws.dto.UserPatchRequestDto
import com.heekng.springwithaws.repository.UserRepository
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