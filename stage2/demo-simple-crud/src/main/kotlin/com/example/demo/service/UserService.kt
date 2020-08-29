package com.example.demo.service

import com.example.demo.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun findById(id: Long): UserDto

    fun modifyUser(userDto: UserDto): UserDto

    fun removeById(id: Long)
}