package com.yly.webdemo

sealed class ResultInfo<T> {
    abstract var code: Int
    abstract var data: T?
    abstract var message: String?
}

class ResultSuccess<T>(override var code: Int = 0,
                       override var data: T? = null,
                       override var message: String? = "success") : ResultInfo<T>()

class ResultFailed<T>(override var code: Int = 1,
                      override var data: T? = null,
                      override var message: String? = "failed") : ResultInfo<T>()