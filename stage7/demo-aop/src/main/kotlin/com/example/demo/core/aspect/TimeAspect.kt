package com.example.demo.core.aspect

import com.example.demo.core.ext.Logging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch


@Aspect
@Component
class TimeAspect : Logging {

    @Pointcut("execution(* com.example.demo.schedule..*(..))")
    fun pointcut() {
    }

    @Around("pointcut()")
    fun before(proceedingJoinPoint: ProceedingJoinPoint) {
        val stopWatch = StopWatch()
        stopWatch.start()
        proceedingJoinPoint.proceed()
        stopWatch.stop()

        log().info("{}::{} costs {} ns", proceedingJoinPoint.signature.declaringTypeName, proceedingJoinPoint.signature.name, stopWatch.totalTimeNanos)
    }

}