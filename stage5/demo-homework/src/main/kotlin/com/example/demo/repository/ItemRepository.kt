package com.example.demo.repository

import com.example.demo.data.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
}