package com.example.demo.schedule

import com.example.demo.core.ext.Logging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MessageSender(
        val rabbitTemplate: RabbitTemplate
) : Logging {

    @Scheduled(cron = "*/10 * * * * *")
    fun sayHello() = rabbitTemplate.convertAndSend("test-exchange", "com.example.demo.mq.123", "Hello Rabbit!")
}