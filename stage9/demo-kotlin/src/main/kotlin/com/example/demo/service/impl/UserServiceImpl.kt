package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService


class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun add(userDto: UserDto): UserDto {
        val user = User(null, userDto.name.split(",")[0].trim(), userDto.name.split(",")[1].trim(), userDto.age)
        val save = userRepository.save(user)
        return UserDto(save.id!!, "${save.firstName}, ${save.lastName}", save.age)
    }

}
