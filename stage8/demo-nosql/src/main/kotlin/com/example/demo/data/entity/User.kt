package com.example.demo.data.entity

import com.example.demo.data.dto.UserDto
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

        @Id
        val id: ObjectId,

        var firstName: String,

        var lastName: String,

        var age: Int,
) {

    fun trans2Dto() = UserDto(this.id.toString(), "${this.firstName}, ${this.lastName}", this.age)
}