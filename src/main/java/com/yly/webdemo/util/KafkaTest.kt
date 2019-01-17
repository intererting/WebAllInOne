package com.yly.webdemo.util

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.beans.factory.annotation.Autowired


@Component
class KafkaTest {

    private val logger by lazy {
        LoggerFactory.getLogger(javaClass)
    }

    @KafkaListener(topics = ["test"], groupId = "myGroup1")
    fun processMessage(content: String) {
        logger.warn("kafka receive ${content}")
    }
}
