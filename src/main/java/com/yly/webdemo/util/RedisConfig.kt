package com.yly.webdemo.util

import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.context.annotation.Configuration

@Configuration
open class RedisConfig : CachingConfigurerSupport() {

    override fun keyGenerator(): KeyGenerator? {
        return KeyGenerator { o, method, values ->
            val sb = StringBuilder()
            sb.append(o.javaClass.name);
            sb.append(method.name);
            for (obj in values) {
                sb.append(obj.toString());
            }
            sb.toString();
        }
    }
}