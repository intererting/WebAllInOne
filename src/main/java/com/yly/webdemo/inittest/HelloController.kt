package com.yly.webdemo.inittest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
internal class HelloController {

    @RequestMapping(value = ["/hello"], method = [RequestMethod.GET])
    fun initTest(): String {
        return "hello springboot"
    }
}