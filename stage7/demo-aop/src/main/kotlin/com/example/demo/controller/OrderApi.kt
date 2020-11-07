package com.example.demo.controller

import com.example.demo.data.dto.OrderDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface OrderApi {

    @PostMapping("/orders")
    fun addOrder(@RequestBody orderDto: OrderDto): OrderDto

    @GetMapping("/orders")
    fun findById(@RequestParam id: Long): OrderDto

    @PutMapping("/orders")
    fun modifyOrder(@RequestBody orderDto: OrderDto): OrderDto

    @DeleteMapping("/orders")
    fun removeById(@RequestParam id: Long)
}