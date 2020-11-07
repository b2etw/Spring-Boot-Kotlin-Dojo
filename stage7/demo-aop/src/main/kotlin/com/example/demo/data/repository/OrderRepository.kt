package com.example.demo.data.repository

import com.example.demo.data.dto.OrderDto
import com.example.demo.data.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    @Query("SELECT new com.example.demo.data.dto.OrderDto(o.id, u.id, u.lastName, i.id, i.name, o.price, o.amount, o.createTime, o.updateTime, o.description) FROM Order o INNER JOIN User u ON o.userId = u.id INNER JOIN Item i ON o.itemId = i.id WHERE o.id = ?1")
    fun findDtoById(id: Long): OrderDto
}