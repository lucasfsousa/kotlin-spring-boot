package com.lucasfsousa.kotlinspringboot.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class AddUser(
        @field:NotEmpty val name: String,
        @field:NotEmpty @field:Email val email: String
)

class UpdateUser(
        @field:NotNull val id: Long,
        @field:NotEmpty val name: String,
        @field:NotEmpty @field:Email val email: String
)

class User(
        val id: Long,
        val name: String,
        val email: String
)