package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.core.exception.UserCrudException
import com.example.demo.data.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        val userRepository: UserRepository
) : UserService {

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
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

    @Cacheable(cacheNames = ["UserService"], key = "#id")
    override fun findById(id: Long) =
            userRepository.findById(id).map {
                UserDto(it.id!!, "${it.firstName}, ${it.lastName}", it.age)
            }.orElseThrow {
                UserCrudException("user id: $id not found in query")
            }

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
    override fun modifyUser(userDto: UserDto) =
            userRepository.findById(userDto.id).orElseThrow {
                UserCrudException("uder id: ${userDto.id} not found in update")
            }.apply {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
                userRepository.save(this)
            }.run {
                UserDto(this.id!!, "${this.firstName}, ${this.lastName}", this.age)
            }

    @CacheEvict(cacheNames = ["UserService"], key = "#id")
    override fun removeById(id: Long) = userRepository.deleteById(id)
}