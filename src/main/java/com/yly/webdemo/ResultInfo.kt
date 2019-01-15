package com.yly.webdemo

sealed class ResultInfo(var code: Int, var message: String)

object ResultSuccess : ResultInfo(0, "success")
object ResultFailed : ResultInfo(1, "failed")