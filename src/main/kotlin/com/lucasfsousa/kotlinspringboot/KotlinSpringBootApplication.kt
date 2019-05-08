package com.lucasfsousa.kotlinspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class KotlinSpringBootApplication {
	@GetMapping("/")
	fun root() = "Getting started with Spring Boot and Kotlin"
}

fun main() {
	runApplication<KotlinSpringBootApplication>()
}
