package com.example.demo.controller

import com.example.demo.data.dto.UserDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface UserApi {

    @PostMapping("/users")
    fun addUser(@RequestBody userDto: UserDto): UserDto

    @GetMapping("/users")
    fun findUserByAge(@RequestParam age: Int): List<UserDto>

    @PutMapping("/users")
    fun modifyUser(@RequestBody userDto: UserDto): UserDto

    @DeleteMapping("/users")
    fun removeUserById(@RequestParam id: String)
}