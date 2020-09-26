package com.example.demo.controller.impl

import com.example.demo.controller.ItemApi
import com.example.demo.data.entity.Item
import com.example.demo.service.ItemService
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController(
        val itemService: ItemService
) : ItemApi {

    override fun addItem(item: Item) = itemService.addItem(item)

    override fun findById(id: Long) = itemService.findById(id)

    override fun modifyItem(item: Item) = itemService.modifyItem(item)

    override fun removeById(id: Long) = itemService.removeById(id)
}