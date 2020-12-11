package com.example.demo.service

import com.example.demo.data.dto.UserDto
import com.example.demo.data.entity.User
import com.example.demo.data.exception.UserCrudException
import com.example.demo.data.repository.UserRepository
import com.example.demo.service.impl.UserServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.annotation.DirtiesContext
import java.util.Optional

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTests {

    @MockBean
    private lateinit var userRepository: UserRepository

    @Test
    internal fun `test add user`() {
        val user = User(null, "Vincent", "Huang", 88)
        given(userRepository.save(user)).willReturn(user.copy(id = 1L))
        val userService: UserService = UserServiceImpl(userRepository)
        val userDto = UserDto(-1L, "Vincent, Huang", 88)

        val addUser = userService.addUser(userDto)

        Assertions.assertThat(addUser.id).isNotNull
        Assertions.assertThat(addUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(addUser.age).isEqualTo(88)
    }

    @Test
    internal fun `test query user by id`() {
        given(userRepository.findById(1L)).willReturn(Optional.of(User(1L, "Vincent", "Huang", 88)))
        val userService: UserService = UserServiceImpl(userRepository)

        val queryUser = userService.queryUserById(1L)

        Assertions.assertThat(queryUser.id).isEqualTo(1L)
        Assertions.assertThat(queryUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(queryUser.age).isEqualTo(88)
    }

    @Test
    internal fun `test query user by id not found`() {
        val userService: UserService = UserServiceImpl(userRepository)
        Assertions.assertThatThrownBy { userService.queryUserById(1L) }.isInstanceOf(UserCrudException::class.java)
    }

    @Test
    internal fun `test modify user`() {
        val user = User(1L, "Vincent", "Huang", 88)
        given(userRepository.findById(1L)).willReturn(Optional.of(user))
        user.firstName = "Victor"
        user.lastName = "Hung"
        user.age = 99
        given(userRepository.save(user)).willReturn(user)
        val userService: UserService = UserServiceImpl(userRepository)
        val userDto = UserDto(1L, "Victor, Hung", 99)

        val modifyUser = userService.modifyUser(userDto)

        Assertions.assertThat(modifyUser.id).isEqualTo(1L)
        Assertions.assertThat(modifyUser.name).isEqualTo("Victor, Hung")
        Assertions.assertThat(modifyUser.age).isEqualTo(99)
    }

    @Test
    internal fun `test modfiy user id not found`() {
        val userService: UserService = UserServiceImpl(userRepository)
        Assertions.assertThatThrownBy { userService.modifyUser(UserDto(2L, "Victor, Hung", 99)) }.isInstanceOf(UserCrudException::class.java)
    }

    @Test
    internal fun `test remove user by id`() {
        val userService: UserService = UserServiceImpl(userRepository)

        userService.removeUserById(1L)

        verify(userRepository).deleteById(1L)
    }
}