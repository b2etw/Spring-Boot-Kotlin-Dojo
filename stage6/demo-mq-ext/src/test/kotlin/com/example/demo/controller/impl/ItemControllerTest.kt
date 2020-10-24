package com.example.demo.controller.impl

import com.example.demo.core.ext.any
import com.example.demo.core.ext.toJsonString
import com.example.demo.data.entity.Item
import com.example.demo.service.impl.ItemServiceImpl
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDateTime

@WebMvcTest(ItemController::class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ItemControllerTest {

    @MockBean
    lateinit var itemServiceImpl: ItemServiceImpl

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testAddItem() {
        val item = Item(null, "soccer ball", 10.0f, LocalDateTime.now(), LocalDateTime.now(), "")
        given(itemServiceImpl.addItem(any(Item::class.java))).willReturn(item.copy(1))

        mockMvc.perform(
                post("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(item.toJsonString())
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(item.copy(1).toJsonString()))
    }

    @Test
    fun testFindById() {
        val item = Item(1, "soccer ball", 10.0f, LocalDateTime.now(), LocalDateTime.now(), "")
        given(itemServiceImpl.findById(1)).willReturn(item)

        mockMvc.perform(
                get("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(item.toJsonString()))
    }

    @Test
    fun testModifyItem() {
        val item = Item(99, "soccer ball", 10.0f, LocalDateTime.now(), LocalDateTime.now(), "")
        given(itemServiceImpl.modifyItem(any(Item::class.java))).willReturn(item)

        mockMvc.perform(
                put("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(item.toJsonString())
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(item.toJsonString()))
    }

    @Test
    fun testRemoveItem() {
        mockMvc.perform(
                delete("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk)
    }
}