package com.yly.webdemo.mapper

import com.yly.webdemo.bean.Human
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select

interface HumanMapper {

    @Select("SELECT *FROM t_user")
    fun getHumans(): List<Human>

    @Insert("INSERT INTO t_user(name,age) values(#{name},#{age})")
    fun insert(human: Human)
}