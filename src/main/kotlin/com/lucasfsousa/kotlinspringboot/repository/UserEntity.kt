package com.lucasfsousa.kotlinspringboot.repository

class UserEntity (
        var id: Long?,
        var name: String,
        var email: String
) {
        constructor(name: String, email: String) : this(
                id = null,
                name = name,
                email = email
        )
}