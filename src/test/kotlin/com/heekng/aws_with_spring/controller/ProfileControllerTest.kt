package com.heekng.aws_with_spring.controller

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.mock.env.MockEnvironment

class ProfileControllerTest {

    @Test
    @DisplayName("real profile이 조회된다.")
    fun realProfile() {
        // given
        val expectedProfile = "real"
        val env = MockEnvironment()
        env.addActiveProfile(expectedProfile)
        env.addActiveProfile("real-db")

        val controller = ProfileController(env)
        // when
        val profile = controller.profile()
        //then
        assertThat(profile).isEqualTo(expectedProfile)
    }

    @Test
    @DisplayName("real profile 이 존재하지 않으면 첫번째 profile이 조회된다.")
    fun realProfileNotExistFirst() {
        // given
        val expectedProfile = "oauth"
        val env = MockEnvironment()
        env.addActiveProfile(expectedProfile)
        env.addActiveProfile("real-db")

        val controller = ProfileController(env)
        // when
        val profile = controller.profile()
        //then
        assertThat(profile).isEqualTo(expectedProfile)
    }

    @Test
    @DisplayName("real profile 이 존재하지 않으면 default 가 조회된다.")
    fun realProfileNotExistDefault() {
        // given
        val expectedProfile = "default"
        val env = MockEnvironment()

        val controller = ProfileController(env)
        // when
        val profile = controller.profile()
        //then
        assertThat(profile).isEqualTo(expectedProfile)
    }


}