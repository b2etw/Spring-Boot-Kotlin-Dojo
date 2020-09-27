package com.example.demo.service.impl

import com.example.demo.data.entity.Item
import com.example.demo.repository.ItemRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDateTime
import java.util.Optional

@SpringBootTest
class ItemServiceImplTest {

    @MockBean
    lateinit var itemRepository: ItemRepository

    @Autowired
    lateinit var itemServiceImpl: ItemServiceImpl

    @Test
    fun testAddItem() {
        val now = LocalDateTime.now()
        given(itemRepository.save(any(Item::class.java))).willReturn(Item(1, "soccer ball", 9.0f, now, now, ""))

        val item = Item(null, "soccer ball", 9.0f, now, now, "")
        val addItem = itemServiceImpl.addItem(item)
        Assertions.assertEquals("soccer ball", addItem.name)
        Assertions.assertEquals(9.0f, addItem.price)
    }

    @Test
    fun testFindById() {
        val now = LocalDateTime.now()
        given(itemRepository.findById(1)).willReturn(Optional.of(Item(1, "soccer ball", 9.0f, now, now, "")))

        val item = itemServiceImpl.findById(1)
        Assertions.assertEquals("soccer ball", item.name)
        Assertions.assertEquals(9.0f, item.price)
    }

    @Test
    fun testModifyItem() {
        val now = LocalDateTime.now()
        given(itemRepository.findById(1)).willReturn(Optional.of(Item(1, "soccer ball", 9.0f, now, now, "")))
        given(itemRepository.save(any(Item::class.java))).willReturn(Item(1, "basketball", 10.0f, now, now, ""))

        val item = Item(1, "basketball", 10.0f, now, now, "")
        val modifyItem = itemServiceImpl.modifyItem(item)
        Assertions.assertEquals("basketball", modifyItem.name)
        Assertions.assertEquals(10.0f, modifyItem.price)
    }
}