package com.example.demo.data.dto

import com.example.demo.data.entity.User
import org.bson.types.ObjectId

data class UserDto(

        val id: String,

        val name: String,

        val age: Int
) {

    fun trans2Entity() = User(if (this.id.isEmpty()) ObjectId() else ObjectId(this.id), this.name.split(",")[0].trim(), this.name.split(",")[1].trim(), this.age)
}
