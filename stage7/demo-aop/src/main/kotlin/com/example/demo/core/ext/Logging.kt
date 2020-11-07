package com.example.demo.core.ext

import org.slf4j.LoggerFactory.getLogger

interface Logging {

    fun <T : Logging> T.log() = getLogger(javaClass)
}