package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        val userRepository: UserRepository
) : UserService {

    override fun addUser(userDto: UserDto) = userRepository.save(userDto.trans2Entity()).trans2Dto()

    override fun findUserByAge(age: Int) =
            userRepository.findByAge(age).map {
                UserDto(it.id.toString(), "${it.firstName}, ${it.lastName}", it.age)
            }

    override fun modifyUser(userDto: UserDto) =
            run {
                userRepository.save(User(ObjectId(userDto.id), userDto.name.split(",")[0].trim(), userDto.name.split(",")[1].trim(), userDto.age))
            }.run {
                UserDto(this.id.toString(), "${this.firstName}, ${this.lastName}", this.age)
            }

    override fun removeUserById(id: String) = userRepository.deleteById(ObjectId(id))
}