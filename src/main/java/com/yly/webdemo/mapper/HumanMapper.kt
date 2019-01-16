package com.yly.webdemo.mapper

import com.yly.webdemo.bean.Human
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

interface HumanMapper {

    @Select("SELECT name,age FROM t_user")
    @Results(
            value = [Result(column = "name", property = "name")
                , Result(column = "age", property = "age")]
    )
    fun getHumans(): ArrayList<Human>

    @Insert("INSERT INTO t_user(name,age) values(#{name},#{age})")
    fun insert(human: Human)
}