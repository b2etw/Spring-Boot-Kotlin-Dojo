package com.example.demo.controller.impl

import com.example.demo.core.ext.any
import com.example.demo.core.ext.toJsonString
import com.example.demo.data.dto.OrderDto
import com.example.demo.service.impl.OrderServiceImpl
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

@WebMvcTest(OrderController::class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OrderControllerTest {

    @MockBean
    lateinit var orderServiceImpl: OrderServiceImpl

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testAddOrder() {
        val orderDto = OrderDto(-1, 1, "", 1, "", 10.0f, 1, LocalDateTime.now(), LocalDateTime.now(), "")
        given(orderServiceImpl.addOrder(any(OrderDto::class.java))).willReturn(orderDto.copy(1))

        mockMvc.perform(
                post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderDto.toJsonString())
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(orderDto.copy(1).toJsonString()))
    }

    @Test
    fun testFindById() {
        val orderDto = OrderDto(1, 1, "Huang", 1, "soccer ball", 10.0f, 1, LocalDateTime.now(), LocalDateTime.now(), "")
        given(orderServiceImpl.findById(1)).willReturn(orderDto)

        mockMvc.perform(
                get("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(orderDto.toJsonString()))
    }

    @Test
    fun testModifyOrder() {
        val orderDto = OrderDto(1, 1, "Huang", 1, "soccer ball", 10.0f, 1, LocalDateTime.now(), LocalDateTime.now(), "")
        given(orderServiceImpl.modifyOrder(any(OrderDto::class.java))).willReturn(orderDto)

        mockMvc.perform(
                put("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderDto.toJsonString())
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(orderDto.toJsonString()))
    }

    @Test
    fun testRemoveOrder() {
        mockMvc.perform(
                delete("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk)
    }
}