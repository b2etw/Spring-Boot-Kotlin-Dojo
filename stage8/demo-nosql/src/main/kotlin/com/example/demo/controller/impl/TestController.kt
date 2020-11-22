package com.example.demo.controller.impl

import com.example.demo.data.dto.UserDto
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
        val stringRedisTemplate: StringRedisTemplate
) {

    @PostMapping("/test")
    fun test(@RequestBody userDto: UserDto): Unit {
        stringRedisTemplate.opsForValue().set("1", userDto.toString())
        stringRedisTemplate.opsForList().leftPush("list", userDto.toString())
        stringRedisTemplate.opsForSet().add("set", userDto.toString())
        stringRedisTemplate.opsForHash<String, String>().put("test", "1", userDto.toString())
    }
}