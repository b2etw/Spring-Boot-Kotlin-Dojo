package com.example.demo.repository

import com.example.demo.data.entity.Item
import com.example.demo.data.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ItemRepository : JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
}