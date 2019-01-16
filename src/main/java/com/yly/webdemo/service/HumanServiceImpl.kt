package com.yly.webdemo.service

import com.fasterxml.jackson.databind.ObjectMapper
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
open class HumanServiceImpl : HumanService {

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
    override fun insertHuman(human: Human) {
        logger.debug(ymlProTest.name)
        for (person in ymlProTest.persons) {
            logger.debug(person.name)
        }
        for ((key, value) in ymlProTest.maps) {
            logger.info("$key   $value")
        }

//  redis
        stringRedisTemplate.opsForValue().set("name", human.name)
        redisBeanTemplate.opsForValue().set("human", human)
        humanMapper.insert(human)
//        humanMapper.insert(Human("异常测试是否回滚", 1))
    }

    override fun getHuman(): ArrayList<Human> {
        val objectMapper = ObjectMapper()
        var result = stringRedisTemplate.opsForValue().get("redisTest")
        if (result.isNullOrEmpty()) {
            val humans = humanMapper.getHumans()
            if (!humans.isNullOrEmpty()) {
                result = objectMapper.writeValueAsString(humans)?.also {
                    stringRedisTemplate.opsForValue().set("redisTest", it)
                }
            }
        }
        result?.apply {
            val listType = objectMapper.typeFactory.constructCollectionType(List::class.java, Human::class.java)
            return objectMapper.readValue(result, listType)
        }
        return arrayListOf()
    }

    /**
     * 保存文件
     */
    override fun saveFile(file: MultipartFile) {
        val destFile = File("d:\\uploadFile.jpg")
        writeFileToDisk(destFile, file.inputStream)
    }
}