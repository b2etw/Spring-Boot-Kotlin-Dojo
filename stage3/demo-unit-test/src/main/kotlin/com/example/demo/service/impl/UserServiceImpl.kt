package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.stereotype.Service

@Service("realUserService")
class UserServiceImpl(
        val userRepository: UserRepository
) : UserService {
    override fun addUser(userDto: UserDto) =
            User(
                    null,
                    userDto.name.split(",")[0].trim(),
                    userDto.name.split(",")[1].trim(),
                    userDto.age
            ).run {
                val save = userRepository.save(this)
                UserDto(save.id!!, "${save.firstName}, ${save.lastName}", save.age)
            }

    override fun findById(id: Long) =
            userRepository.findById(id).map {
                UserDto(it.id!!, "${it.firstName}, ${it.lastName}", it.age)
            }.orElseThrow {
                RuntimeException()
            }

    override fun modifyUser(userDto: UserDto) =
            userRepository.findById(userDto.id).orElseThrow {
                RuntimeException()
            }.apply {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
                userRepository.save(this)
            }.run {
                UserDto(this.id!!, "${this.firstName}, ${this.lastName}", this.age)
            }

    override fun removeById(id: Long) = userRepository.deleteById(id)
}