package com.yly.webdemo.controller

import com.yly.webdemo.ResultFailed
import com.yly.webdemo.ResultInfo
import com.yly.webdemo.ResultSuccess
import com.yly.webdemo.bean.Human
import com.yly.webdemo.service.HumanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class HumanController {

    @Autowired
    lateinit var humanService: HumanService

    @PostMapping(value = ["/insertHuman"])
    fun insertHuman(@RequestParam("name") name: String
                    , @RequestParam("age") age: Int): ResultInfo<Unit> {
        try {
            humanService.insertHuman(human = Human(name, age))
            return ResultSuccess()
        } catch (e: Exception) {
            return ResultFailed(message = e.message)
        }
    }

    @GetMapping(value = ["/testSecurity"])
    fun testSecurity(): ResultInfo<Unit> {
        return ResultSuccess()
    }

    @PostMapping(value = ["/insertHumanBean"])
    fun insertHuman(@RequestBody human: Human): ResultInfo<Unit> {
        try {
            humanService.insertHuman(human = human)
            return ResultSuccess()
        } catch (e: Exception) {
            e.printStackTrace()
            return ResultFailed(message = e.message)
        }
    }

    @PostMapping(value = ["/getHumans"])
    fun getHumans(): ResultInfo<List<Human>> {
        try {
            val result = humanService.getHuman()
            return ResultSuccess(data = result)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResultFailed(message = e.message)
        }
    }

    @PostMapping(value = ["/uploadFile"])
    fun insertHumanWithFile(@RequestParam file: MultipartFile): ResultInfo<Unit> {
        try {
            humanService.saveFile(file)
            return ResultSuccess()
        } catch (e: Exception) {
            e.printStackTrace()
            return ResultFailed(message = e.message)
        }
    }

}