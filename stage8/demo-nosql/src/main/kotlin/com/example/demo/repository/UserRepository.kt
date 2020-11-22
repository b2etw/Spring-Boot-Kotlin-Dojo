package com.example.demo.repository

import com.example.demo.data.entity.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository


interface UserRepository : MongoRepository<User, ObjectId> {

    fun findByAge(age: Int): List<User>
}