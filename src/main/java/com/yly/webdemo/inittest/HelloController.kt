package com.yly.webdemo.inittest

import com.yly.webdemo.bean.Human
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
internal class HelloController {

    @RequestMapping(value = ["/hello"], method = [RequestMethod.GET])
    fun initTest(): String {
        return "hello springboot"
    }

    @RequestMapping(value = ["/bean"], method = [RequestMethod.GET])
    fun retureBean(): Human {
        return Human("yuliyang", 22)
    }

    @RequestMapping(value = ["/hello/{id}"], method = [RequestMethod.GET])
    fun getGetParams(@PathVariable id: String): String {
        return "hello springboot $id"
    }
}