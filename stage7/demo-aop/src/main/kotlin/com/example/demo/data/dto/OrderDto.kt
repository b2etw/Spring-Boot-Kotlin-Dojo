package com.example.demo.data.dto

import java.io.Serializable
import java.time.LocalDateTime

data class OrderDto(

        val id: Long,

        val userId: Long,

        val userLastName: String,

        val itemId: Long,

        val itemName: String,

        val price: Float,

        val amount: Int,

        val createTime: LocalDateTime,

        val updateTime: LocalDateTime,

        val description: String
): Serializable
