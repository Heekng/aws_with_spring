package com.heekng.aws_with_spring.repository

import com.heekng.aws_with_spring.entity.User
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class UserRepositoryTest @Autowired constructor(
    private val userRepository: UserRepository,
) {

    @Test
    @DisplayName("유저가 저장 후 정상 조회된다.")
    fun saveUserTest() {
        // given
        val user = User(
            name = "heekng",
            phone = "01012341234"
        )
        // when
        userRepository.save(user)
        // then
        val findUser = userRepository.findById(user.id!!).get()
        assertThat(findUser).isEqualTo(user)
    }

    @Test
    @DisplayName("저장된 유저는 이름으로 검색된다.")
    fun findByNameTest() {
        // given
        val user = User(
            name = "heekng",
            phone = "01012341234"
        )
        userRepository.save(user)
        // when
        val findUser = userRepository.findByName(user.name)
        // then
        assertThat(findUser).isEqualTo(user)
    }

    @Test
    @DisplayName("저장된 유저는 전화번호로 검색된다.")
    fun findByPhoneTest() {
        // given
        val user = User(
            name = "heekng",
            phone = "01012341234"
        )
        userRepository.save(user)
        // when
        val findUser = userRepository.findByPhone(user.phone)
        // then
        assertThat(findUser).isEqualTo(user)
    }
}