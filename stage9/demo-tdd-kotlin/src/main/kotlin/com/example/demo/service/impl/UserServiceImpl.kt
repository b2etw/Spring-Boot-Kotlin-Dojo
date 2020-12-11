package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.data.exception.UserCrudException
import com.example.demo.data.repository.UserRepository
import com.example.demo.service.UserService

class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun addUser(userDto: UserDto) =
            userDto.run {
                val user = User(
                        null,
                        this.name.split(",")[0].trim(),
                        this.name.split(",")[1].trim(),
                        this.age)

                val save = userRepository.save(user)
                UserDto(save.id!!, "${save.firstName}, ${save.lastName}", save.age)
            }

    override fun queryUserById(id: Long) =
            userRepository.findById(id).orElseThrow {
                UserCrudException("query user error, id : $id not exist")
            }.run {
                UserDto(this.id!!, "${this.firstName}, ${this.lastName}", this.age)
            }

    override fun modifyUser(userDto: UserDto) =
            userRepository.findById(userDto.id).orElseThrow {
                UserCrudException("modify user error, id : ${userDto.id} not exist")
            }.apply {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
            }.run {
                val save = userRepository.save(this)
                UserDto(save.id!!, save.firstName + ", " + save.lastName, save.age)
            }

    override fun removeUserById(id: Long) = userRepository.deleteById(id)
}
