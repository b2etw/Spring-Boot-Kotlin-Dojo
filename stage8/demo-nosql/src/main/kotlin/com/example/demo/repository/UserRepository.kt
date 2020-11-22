package com.example.demo.repository

import com.example.demo.data.entity.User
import org.springframework.data.mongodb.repository.MongoRepository


interface UserRepository : MongoRepository<User, String> {

    fun findByLastName(lastName: String): List<User>
}