package com.lucasfsousa.kotlinspringboot.exceptions

class CustomError(val message: String?)

class UserNotFoundException(id: Long) : RuntimeException("User with id: $id was not found")

class UserAlreadyExistsException(email: String) : RuntimeException("User with email $email already exists")