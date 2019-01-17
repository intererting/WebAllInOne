package com.yly.webdemo.inittest

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class MyRunner : ApplicationRunner {

    private val logger by lazy {
        LoggerFactory.getLogger(javaClass)
    }


    override fun run(args: ApplicationArguments?) {
        //If you need to run some specific code once the SpringApplication has started
        logger.info("MyRunner")
    }
}