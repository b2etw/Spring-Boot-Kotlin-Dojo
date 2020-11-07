package com.example.demo.controller.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.service.impl.UserServiceImpl
import com.fasterxml.jackson.databind.ObjectMapper
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

@WebMvcTest(UserController::class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @MockBean
    lateinit var userServiceImpl: UserServiceImpl

    @Autowired
    lateinit var mockMvc: MockMvc

    private val objectMapper = ObjectMapper()

    @Test
    fun testAddUser() {
        val userDto = UserDto(-1, "Vincent, Huang", 88)
        given(userServiceImpl.addUser(userDto)).willReturn(userDto.copy(1))

        mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto))
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(objectMapper.writeValueAsString(userDto.copy(1))))
    }

    @Test
    fun testFindById() {
        val userDto = UserDto(1, "Vincent, Huang", 88)
        given(userServiceImpl.findById(1)).willReturn(userDto)

        mockMvc.perform(
                get("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(objectMapper.writeValueAsString(userDto)))
    }

    @Test
    fun testModifyUser() {
        val userDto = UserDto(1, "Victor, Huang", 90)
        given(userServiceImpl.modifyUser(userDto)).willReturn(userDto)

        mockMvc.perform(
                put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto))
        )
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(objectMapper.writeValueAsString(userDto)))
    }

    @Test
    fun testRemoveUser() {
        mockMvc.perform(
                delete("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk)
    }
}