package com.yly.webdemo.service

import com.yly.webdemo.bean.Human
import com.yly.webdemo.mapper.HumanMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class HumanService {

    @Autowired
    lateinit var humanMapper: HumanMapper

    @Transactional
    open fun insertHuman(human: Human) {
        humanMapper.insert(human)
        humanMapper.insert(Human("异常测试是否回滚", 1))
    }
}