package com.example.demo.controller.impl

import com.example.demo.controller.OrderApi
import com.example.demo.data.dto.OrderDto
import com.example.demo.service.OrderService
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
        val orderService: OrderService
) : OrderApi {

    override fun addOrder(orderDto: OrderDto) = orderService.addOrder(orderDto)

    override fun findById(id: Long) = orderService.findById(id)

    override fun modifyOrder(orderDto: OrderDto) = orderService.modifyOrder(orderDto)

    override fun removeById(id: Long) = orderService.removeById(id)
}