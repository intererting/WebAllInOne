package com.yly.webdemo.service

import com.yly.webdemo.bean.Human
import org.springframework.web.multipart.MultipartFile

interface HumanService {

    fun getHuman(): ArrayList<Human>

    fun insertHuman(human: Human)

    fun saveFile(file: MultipartFile)

}