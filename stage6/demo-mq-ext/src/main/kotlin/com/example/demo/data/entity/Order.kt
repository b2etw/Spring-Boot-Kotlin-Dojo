package com.example.demo.data.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "orders")
data class Order(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long?,

        @Column
        var userId: Long,

        @Column
        var itemId: Long,

        @Column
        var price: Float,

        @Column
        var amount: Int,

        @Column
        var createTime: LocalDateTime,

        @Column
        var updateTime: LocalDateTime,

        @Column
        var description: String
): Serializable
