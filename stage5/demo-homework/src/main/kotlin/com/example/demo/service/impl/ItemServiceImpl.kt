package com.example.demo.service.impl

import com.example.demo.data.entity.Item
import com.example.demo.core.exception.ItemCrudException
import com.example.demo.data.repository.ItemRepository
import com.example.demo.service.ItemService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ItemServiceImpl(
        var itemRepository: ItemRepository
) : ItemService {

    override fun addItem(item: Item) = itemRepository.save(item.copy(updateTime = LocalDateTime.now()))

    override fun findById(id: Long) = itemRepository.findById(id).orElseThrow { ItemCrudException("item id: $id not found in query") }

    override fun modifyItem(item: Item) =
            itemRepository.findById(item.id!!).orElseThrow {
                ItemCrudException("item id: ${item.id} not found in update")
            }.run {
                this.name = item.name
                this.price = item.price
                this.updateTime = LocalDateTime.now()
                this.description = item.description
                itemRepository.save(this)
            }

    override fun removeById(id: Long) = itemRepository.deleteById(id)
}