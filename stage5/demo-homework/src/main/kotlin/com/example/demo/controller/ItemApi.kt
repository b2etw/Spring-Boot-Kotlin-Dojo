package com.example.demo.controller

import com.example.demo.data.entity.Item
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface ItemApi {

    @PostMapping("/items")
    fun addItem(@RequestBody item: Item): Item

    @GetMapping("/items")
    fun findById(@RequestParam id: Long): Item

    @PutMapping("/items")
    fun modifyItem(@RequestBody item: Item): Item

    @DeleteMapping("/items")
    fun removeById(@RequestParam id: Long)
}