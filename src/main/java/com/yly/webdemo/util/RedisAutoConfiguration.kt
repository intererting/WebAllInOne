package com.yly.webdemo.util

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.io.Serializable


@Configuration
open class RedisAutoConfiguration {

    @Bean
    open fun redisBeanTemplate(redisConnectionFactory: LettuceConnectionFactory): RedisTemplate<String, Serializable> {
        val template = RedisTemplate<String, Serializable>()
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = GenericJackson2JsonRedisSerializer()
        template.connectionFactory = redisConnectionFactory
        return template
    }

}