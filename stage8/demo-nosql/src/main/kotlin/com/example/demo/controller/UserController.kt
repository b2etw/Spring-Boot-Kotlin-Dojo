package com.example.demo.controller

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        val userRepository: UserRepository
) {

    @PostMapping("/users")
    fun addUser(@RequestBody userDto: UserDto) = userRepository.save(User(null, userDto.name.split(",")[0].trim(), userDto.name.split(",")[1].trim(), userDto.age, System.currentTimeMillis()))
}