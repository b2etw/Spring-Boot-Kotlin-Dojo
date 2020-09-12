package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.service.UserService
import org.springframework.stereotype.Service

@Service("dummyUserService")
class DummyUserService : UserService {

    override fun addUser(userDto: UserDto) = UserDto(-1, "Dummy, Service Add", 999)

    override fun findById(id: Long) = UserDto(-1, "Dummy, Service Find", 999)

    override fun modifyUser(userDto: UserDto) = UserDto(-1, "Dummy, Service Modify", 999)

    override fun removeById(id: Long) { print("Dummy, Service Remove")}
}