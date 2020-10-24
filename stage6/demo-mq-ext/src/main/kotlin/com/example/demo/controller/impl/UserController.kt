package com.example.demo.controller.impl

import com.example.demo.controller.UserApi
import com.example.demo.data.dto.UserDto
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        val realUserService : UserService
) : UserApi {

    override fun addUser(userDto: UserDto) = realUserService.addUser(userDto)

    override fun findById(id: Long) = realUserService.findById(id)

    override fun modifyUser(userDto: UserDto) = realUserService.modifyUser(userDto)

    override fun removeById(id: Long) = realUserService.removeById(id)
}