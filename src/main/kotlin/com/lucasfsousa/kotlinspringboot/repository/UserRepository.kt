package com.lucasfsousa.kotlinspringboot.repository

interface UserRepository {
    fun existsById(id: Long): Boolean
    fun existsByEmail(email: String): Boolean

    fun findAll(): List<UserEntity>
    fun findByIdOrNull(id: Long): UserEntity?

    fun save(user: UserEntity): UserEntity

    fun deleteById(id: Long)
}