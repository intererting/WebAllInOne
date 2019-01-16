package com.yly.webdemo

sealed class ResultInfo {
    abstract var code: Int
    abstract var message: String?
}

class ResultSuccess(override var code: Int = 0,
                    override var message: String? = "success") : ResultInfo()

class ResultFailed(override var code: Int = 1,
                   override var message: String? = "failed") : ResultInfo()