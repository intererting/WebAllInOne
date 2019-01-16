package com.yly.webdemo.util

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class SpringMvcConfigure : WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {

        registry.addResourceHandler("/image/**").addResourceLocations("file:E:/serverPic/");
        super.addResourceHandlers(registry)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(MyInterceptor())
        super.addInterceptors(registry)
    }

}