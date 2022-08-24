package com.heekng.aws_with_spring.controller

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileController(
    private val env: Environment
) {

    @GetMapping("/profile")
    fun profile(): String {
        val profiles: List<String> = env.activeProfiles.toList()
        val realProfiles = listOf("real", "real1", "real2")
        val defaultProfile = if(profiles.isEmpty()) return "default" else profiles[0]
        return profiles.find { realProfiles.contains(it) } ?: defaultProfile
    }
}