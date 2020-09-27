package com.example.demo.service.impl

import com.example.demo.data.dto.OrderDto
import com.example.demo.data.entity.Order
import com.example.demo.core.exception.ItemCrudException
import com.example.demo.core.exception.OrderCrudException
import com.example.demo.data.repository.ItemRepository
import com.example.demo.data.repository.OrderRepository
import com.example.demo.data.repository.UserRepository
import com.example.demo.service.OrderService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OrderServiceImpl(
        val userRepository: UserRepository,
        val itemRepository: ItemRepository,
        val orderRepository: OrderRepository
) : OrderService {

    override fun addOrder(orderDto: OrderDto) = let {
        val user = userRepository.findById(orderDto.userId).orElseThrow {
            OrderCrudException("user id: ${orderDto.userId} not found in add")
        }
        val item = itemRepository.findById(orderDto.itemId).orElseThrow {
            ItemCrudException("item id : ${orderDto.itemId} not found in add")
        }
        val order = Order(null, user.id!!, item.id!!, item.price, orderDto.amount, LocalDateTime.now(), LocalDateTime.now(), "")
        val savedOrder = orderRepository.save(order)

        OrderDto(savedOrder.id!!, user.id, user.lastName, item.id, item.name, savedOrder.price, savedOrder.amount, savedOrder.createTime, savedOrder.updateTime, savedOrder.description)
    }

    override fun findById(id: Long) = orderRepository.findDtoById(id)

    override fun modifyOrder(orderDto: OrderDto) =
            orderRepository.findById(orderDto.id).orElseThrow {
                OrderCrudException("user id: ${orderDto.userId} not found in modify")
            }.run {
                this.copy(userId = orderDto.userId, itemId = orderDto.itemId, price = orderDto.price, amount = orderDto.amount, updateTime = orderDto.updateTime, description = orderDto.description)
            }.run {
                orderRepository.save(this)
            }.run {
                val user = userRepository.findById(orderDto.userId).orElseThrow {
                    OrderCrudException("user id: ${orderDto.userId} not found in modify")
                }
                val item = itemRepository.findById(orderDto.itemId).orElseThrow {
                    ItemCrudException("item id : ${orderDto.itemId} not found in modify")
                }

                OrderDto(this.id!!, user.id!!, user.lastName, item.id!!, item.name, this.price, this.amount, this.createTime, this.updateTime, this.description)
            }

    override fun removeById(id: Long) = orderRepository.deleteById(id)
}