package com.example.demo.controller

import com.example.demo.data.dto.UserDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface UserApi {

    @PostMapping("/user")
    fun addUser(@RequestBody userDto: UserDto): UserDto

    @GetMapping("/user")
    fun findById(@RequestParam id: Long): UserDto

    @PutMapping("/user")
    fun modifyUser(@RequestBody userDto: UserDto): UserDto

    @DeleteMapping("/user")
    fun removeById(@RequestParam id: Long)
}