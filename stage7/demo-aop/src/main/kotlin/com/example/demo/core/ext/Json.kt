package com.example.demo.core.ext

import com.example.demo.core.ext.Json.objectMapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

object Json {

    val objectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .registerModule(JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
}

fun Any?.toJsonString() = objectMapper.writeValueAsString(this)

fun <T> String.jsonStringToObject(clazz: Class<T>): T = objectMapper.readValue(this, clazz)