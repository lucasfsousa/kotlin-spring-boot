package com.lucasfsousa.kotlinspringboot.repository

import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

/**
 * Dummy implementation for UserRepository
 * This can be easily replaced by Spring Data JPA
 */
@Component
class UserRepositoryImpl : UserRepository {
    private val lastId = AtomicLong()
    private val list = mutableListOf<UserEntity>()

    override fun existsById(id: Long) = list.filter { it.id == id  }.count() > 0

    override fun existsByEmail(email: String) = list.filter { it.email == email  }.count() > 0

    override fun findAll() = list

    override fun findByIdOrNull(id: Long) = list.filter { it.id == id }.firstOrNull()

    override fun save(user: UserEntity): UserEntity {
        if (user.id == null) {
            user.id = lastId.incrementAndGet()
            list.add(user)
        } else {
            list[findIndex(user.id!!)] = user
        }
        return user
    }

    override fun deleteById(id: Long) {
        list.removeAt(findIndex(id))
        list.dropWhile { it.id == id }
    }

    private fun findIndex(id: Long) =
            list.mapIndexed { index, userEntity -> index to userEntity }.first { it.second.id == id }.first

}