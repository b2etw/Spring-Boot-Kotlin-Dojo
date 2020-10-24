package com.example.demo.controller.impl

import com.example.demo.controller.OrderApi
import com.example.demo.data.dto.OrderDto
import com.example.demo.service.OrderService
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
        val OrderService: OrderService
) : OrderApi {

    override fun addOrder(orderDto: OrderDto) = OrderService.addOrder(orderDto)

    override fun findById(id: Long) = OrderService.findById(id)

    override fun modifyOrder(orderDto: OrderDto) = OrderService.modifyOrder(orderDto)

    override fun removeById(id: Long) = OrderService.removeById(id)
}