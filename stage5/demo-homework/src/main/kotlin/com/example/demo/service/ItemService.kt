package com.example.demo.service

import com.example.demo.data.entity.Item

interface ItemService {

    fun addItem(item: Item): Item

    fun findById(id: Long): Item

    fun modifyItem(item: Item): Item

    fun removeById(id: Long)
}
