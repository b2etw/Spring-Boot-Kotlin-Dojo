package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.Optional

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userServiceImpl: UserServiceImpl

    @Test
    fun testAddUser() {
        given(userRepository.save(User(null, "Vincent", "Huang", 90))).willReturn(User(1, "Vincent", "Huang", 90))

        Assertions.assertEquals("Vincent, Huang", userServiceImpl.addUser(UserDto(-1, "Vincent, Huang", 90)).name)
        Assertions.assertEquals(90, userServiceImpl.addUser(UserDto(-1, "Vincent, Huang", 90)).age)
    }

    @Test
    fun testFindById() {
        given(userRepository.findById(1)).willReturn(Optional.of(User(1, "Vincent", "Huang", 88)))

        Assertions.assertEquals("Vincent, Huang", userServiceImpl.findById(1).name)
        Assertions.assertEquals(88, userServiceImpl.findById(1).age)
    }

    @Test
    fun testModifyUser() {
        given(userRepository.findById(1)).willReturn(Optional.of(User(1, "Vincent", "Huang", 88)))
        given(userRepository.save(User(1, "Victor", "Huang", 90))).willReturn(User(1, "Victor", "Huang", 90))

        Assertions.assertEquals("Victor, Huang", userServiceImpl.modifyUser(UserDto(1, "Victor, Huang", 90)).name)
        Assertions.assertEquals(90, userServiceImpl.modifyUser(UserDto(1, "Victor, Huang", 90)).age)
    }
}