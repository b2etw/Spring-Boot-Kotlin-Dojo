package com.example.demo.controller.impl

import com.example.demo.controller.UserApi
import com.example.demo.data.dto.UserDto
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        @Qualifier("RealUserService") val userService : UserService
) : UserApi {

    override fun addUser(userDto: UserDto) = userService.addUser(userDto)

    override fun findById(id: Long) = userService.findById(id)

    override fun modifyUser(userDto: UserDto) = userService.modifyUser(userDto)

    override fun removeById(id: Long) = userService.removeById(id)
}