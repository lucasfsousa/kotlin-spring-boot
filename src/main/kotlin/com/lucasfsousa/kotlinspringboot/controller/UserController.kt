package com.lucasfsousa.kotlinspringboot.controller

import com.lucasfsousa.kotlinspringboot.service.UserService
import com.lucasfsousa.kotlinspringboot.model.AddUser
import com.lucasfsousa.kotlinspringboot.model.UpdateUser
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @GetMapping
    fun list() = userService.list()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = userService.get(id)

    @PostMapping
    @ResponseStatus(CREATED)
    fun add(@RequestBody @Valid addUser: AddUser) = userService.add(addUser)

    @PutMapping
    @ResponseStatus(NO_CONTENT)
    fun update(@RequestBody @Valid updateUser: UpdateUser) = userService.update(updateUser)

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    fun delete(@PathVariable id: Long) = userService.delete(id)
}