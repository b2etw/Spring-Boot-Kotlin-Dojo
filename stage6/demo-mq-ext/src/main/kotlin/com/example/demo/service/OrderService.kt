package com.example.demo.service

import com.example.demo.data.dto.OrderDto

interface OrderService {

    fun addOrder(orderDto: OrderDto): OrderDto

    fun findById(id: Long): OrderDto

    fun modifyOrder(orderDto: OrderDto): OrderDto

    fun removeById(id: Long)
}