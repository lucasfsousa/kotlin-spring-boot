package com.lucasfsousa.kotlinspringboot.service

import com.lucasfsousa.kotlinspringboot.model.AddUser
import com.lucasfsousa.kotlinspringboot.model.User
import com.lucasfsousa.kotlinspringboot.repository.UserEntity

fun List<UserEntity>.toModel() = this.map { it.toModel() }

fun UserEntity.toModel() = User(id = this.id!!, name = this.name, email = this.email)

fun AddUser.toEntity() = UserEntity(name = this.name, email = this.email)