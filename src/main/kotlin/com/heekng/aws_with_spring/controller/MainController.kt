package com.heekng.aws_with_spring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/")
    fun mainPage(
        @RequestParam(required = false) message: String? = null,
    ): String {
        return message ?: return "no message"
    }
}