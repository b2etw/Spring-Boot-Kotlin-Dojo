package com.example.demo.schedule

import com.example.demo.core.ext.Logging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DemoTask: Logging {

    @Scheduled(cron = "*/10 * * * * *")
    fun sayHello() = log().info("Hi Hi, now is ${LocalDateTime.now()}")
}