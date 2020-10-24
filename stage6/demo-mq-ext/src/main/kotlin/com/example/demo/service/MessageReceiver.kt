package com.example.demo.service

import com.example.demo.core.ext.Logging
import org.springframework.stereotype.Component

@Component
class MessageReceiver : Logging {

    fun receiveMsg(msg: String) = log().info(msg)
}