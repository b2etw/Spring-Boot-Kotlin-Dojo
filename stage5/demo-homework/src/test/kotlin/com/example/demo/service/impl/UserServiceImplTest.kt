package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.data.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.annotation.DirtiesContext
import java.util.Optional

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@EnableAutoConfiguration(exclude = [RedisAutoConfiguration::class])
class UserServiceImplTest {

    @MockBean
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userServiceImpl: UserServiceImpl

    @Test
    fun testAddUser() {
        val user = User(null, "Vincent", "Huang", 90)
        given(userRepository.save(user)).willReturn(user.copy(1))

        val userDto = UserDto(-1, "Vincent, Huang", 90)
        val addUser = userServiceImpl.addUser(userDto)
        Assertions.assertEquals("Vincent, Huang", addUser.name)
        Assertions.assertEquals(90, addUser.age)
    }

    @Test
    fun testFindById() {
        given(userRepository.findById(1)).willReturn(Optional.of(User(1, "Vincent", "Huang", 88)))

        val userDto = userServiceImpl.findById(1)
        Assertions.assertEquals("Vincent, Huang", userDto.name)
        Assertions.assertEquals(88, userDto.age)
    }

    @Test
    fun testModifyUser() {
        given(userRepository.findById(1)).willReturn(Optional.of(User(1, "Vincent", "Huang", 88)))
        given(userRepository.save(User(1, "Victor", "Huang", 90))).willReturn(User(1, "Victor", "Huang", 90))

        val userDto = UserDto(1, "Victor, Huang", 90)
        val modifyUser = userServiceImpl.modifyUser(userDto)
        Assertions.assertEquals("Victor, Huang", modifyUser.name)
        Assertions.assertEquals(90, modifyUser.age)
    }
}