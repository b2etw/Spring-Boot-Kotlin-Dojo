package com.example.demo.core.aspect

import com.example.demo.core.ext.Logging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.Arrays


@Aspect
@Component
class LogAspect : Logging {

    @Pointcut("execution(* com.example.demo.controller.impl..*(..))")
    fun pointcut() {
    }

    @Before("pointcut()")
    fun before(joinPoint: JoinPoint) {
        log().info("args -> {}", Arrays.toString(joinPoint.args))
    }

}