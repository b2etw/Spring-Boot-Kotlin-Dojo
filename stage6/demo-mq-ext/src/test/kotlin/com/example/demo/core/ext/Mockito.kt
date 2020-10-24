package com.example.demo.core.ext

import org.mockito.Mockito

fun <T> any(type : Class<T>): T {
    Mockito.any(type)
    return uninitialized()
}

private fun <T> uninitialized(): T = null as T