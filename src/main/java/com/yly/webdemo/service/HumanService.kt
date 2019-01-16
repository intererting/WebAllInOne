package com.yly.webdemo.service

import com.yly.webdemo.YmlProTest
import com.yly.webdemo.bean.Human
import com.yly.webdemo.extends.writeFileToDisk
import com.yly.webdemo.mapper.HumanMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.Serializable

@Service
open class HumanService {

    private val logger by lazy {
        LoggerFactory.getLogger(javaClass)
    }

    @Autowired
    lateinit var humanMapper: HumanMapper

    @Autowired
    lateinit var ymlProTest: YmlProTest

    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate

    @Autowired
    lateinit var redisBeanTemplate: RedisTemplate<String, Serializable>

    @Transactional
    open fun insertHuman(human: Human) {
//         logger.debug(ymlProTest.name)
//        for (person in ymlProTest.persons) {
//             logger.debug(person.name)
//        }
//        for ((key, value) in ymlProTest.maps) {
//            logger.info("$key   $value")
//        }

        //redis
//        stringRedisTemplate.opsForValue().set("name", human.name)
        redisBeanTemplate.opsForValue().set("human", human)
        humanMapper.insert(human)
//        humanMapper.insert(Human("异常测试是否回滚", 1))
    }

    /**
     * 保存文件
     */
    fun saveFile(file: MultipartFile) {
        val destFile = File("d:\\uploadFile.jpg")
        writeFileToDisk(destFile, file.inputStream)
    }
}