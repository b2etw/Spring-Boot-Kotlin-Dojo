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
@Table
data class Item(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long?,

        @Column
        var name: String,

        @Column
        var price: Float,

        @Column
        var createTime: LocalDateTime,

        @Column
        var updateTime: LocalDateTime,

        @Column
        var description: String
): Serializable
