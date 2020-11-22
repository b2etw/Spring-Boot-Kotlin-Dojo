package com.example.demo.controller.impl

import com.example.demo.controller.UserApi
import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        val userService: UserService
) : UserApi {

    override fun addUser(userDto: UserDto) = userService.addUser(userDto)

    override fun findUserByAge(age: Int) = userService.findUserByAge(age)

    override fun modifyUser(userDto: UserDto) = userService.modifyUser(userDto)

    override fun removeUserById(id: String) = userService.removeUserById(id)
}