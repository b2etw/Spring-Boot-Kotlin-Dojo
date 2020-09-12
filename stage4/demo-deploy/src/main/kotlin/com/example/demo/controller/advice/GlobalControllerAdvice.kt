package com.example.demo.controller.advice

import com.example.demo.exception.UserCrudException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(UserCrudException::class)
    fun handleUserCrudException(ex: UserCrudException): ResponseEntity<*> {
        ex.printStackTrace()
        return ResponseEntity.badRequest().body(ex.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<*> {
        ex.printStackTrace()
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("亲，这个功能正在维护的唷，请耐心等候");
    }
}