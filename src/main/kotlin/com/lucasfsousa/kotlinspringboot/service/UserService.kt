package com.lucasfsousa.kotlinspringboot.service

import com.lucasfsousa.kotlinspringboot.model.AddUser
import com.lucasfsousa.kotlinspringboot.model.UpdateUser
import com.lucasfsousa.kotlinspringboot.model.User

interface UserService {
    fun add(addUser: AddUser): User
    fun get(id: Long): User
    fun update(updateUser: UpdateUser): User
    fun list(): List<User>
    fun delete(id: Long)
}