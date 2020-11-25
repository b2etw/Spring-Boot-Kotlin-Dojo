package com.example.demo.service

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.impl.UserServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class UserServiceTests {
    @MockBean
    lateinit var userRepository: UserRepository

    @Test
    internal fun `test_add_user`() {
        given(userRepository.save(User(null, "Vincent", "Huang", 88))).willReturn(User(1, "Vincent", "Huang", 88))
        val userService: UserService = UserServiceImpl(userRepository)
        val userDto = UserDto(-1, "Vincent, Huang", 88)

        val addUser = userService.add(userDto)

        Assertions.assertThat(addUser.id).isNotNull()
        Assertions.assertThat(addUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(addUser.age).isEqualTo(88)
    }

}