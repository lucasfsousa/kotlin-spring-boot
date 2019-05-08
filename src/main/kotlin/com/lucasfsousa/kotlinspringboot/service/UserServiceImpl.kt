package com.lucasfsousa.kotlinspringboot.service

import com.lucasfsousa.kotlinspringboot.exceptions.UserAlreadyExistsException
import com.lucasfsousa.kotlinspringboot.exceptions.UserNotFoundException
import com.lucasfsousa.kotlinspringboot.model.AddUser
import com.lucasfsousa.kotlinspringboot.model.UpdateUser
import com.lucasfsousa.kotlinspringboot.model.User
import com.lucasfsousa.kotlinspringboot.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserInterfaceImpl(val repository: UserRepository): UserService {

    override fun add(addUser: AddUser): User {
        if (repository.existsByEmail(addUser.email)) {
            throw UserAlreadyExistsException(addUser.email)
        }

        val userEntity = repository.save(addUser.toEntity())
        return userEntity.toModel()
    }

    override fun get(id: Long) = assertUserExists(id).toModel()

    override fun update(updateUser: UpdateUser): User {
        val userEntity = assertUserExists(updateUser.id)
        userEntity.name = updateUser.name
        if (userEntity.email != updateUser.email) {
            assertEmailIsNotUsed(updateUser.email)
            userEntity.email = updateUser.email
        }
        return repository.save(userEntity).toModel()
    }

    override fun list() = repository.findAll().toModel()

    override fun delete(id: Long) {
        if (!repository.existsById(id)) {
            throw UserNotFoundException(id)
        }
        repository.deleteById(id)
    }

    private fun assertUserExists(id: Long) = repository.findByIdOrNull(id) ?: throw UserNotFoundException(id)

    private fun assertEmailIsNotUsed(email: String) {
        if (repository.existsByEmail(email)) {
            throw UserAlreadyExistsException(email)
        }
    }
}