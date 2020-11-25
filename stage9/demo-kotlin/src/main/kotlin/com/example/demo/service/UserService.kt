package com.example.demo.service

import com.example.demo.data.dto.UserDto

interface UserService {
    fun add(userDto: UserDto): UserDto

}
