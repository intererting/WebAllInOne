package com.yly.webdemo.controller

import com.yly.webdemo.ResultFailed
import com.yly.webdemo.ResultInfo
import com.yly.webdemo.ResultSuccess
import com.yly.webdemo.bean.Human
import com.yly.webdemo.service.HumanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HumanController {

    @Autowired
    lateinit var humanService: HumanService

    @PostMapping(value = ["/insertHuman"])
    fun insertHuman(@RequestParam("name") name: String
                    , @RequestParam("age") age: Int): ResultInfo {
        try {
            humanService.insertHuman(human = Human(name, age))
            return ResultSuccess
        } catch (e: Exception) {
            return ResultFailed
        }
    }

}