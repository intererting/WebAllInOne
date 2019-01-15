package com.yly.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@SpringBootApplication
@EnableConfigurationProperties(YmlProTest.class)
@MapperScan("com.yly.webdemo.mapper")
public class WebdemoApplication {

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebdemoApplication.class);
        springApplication.addListeners((ApplicationListener<ApplicationEvent>) applicationEvent -> {
            if (applicationEvent instanceof ApplicationStartingEvent) {
                System.out.println("ApplicationStartingEvent");
            } else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
                System.out.println("ApplicationEnvironmentPreparedEvent");
            } else if (applicationEvent instanceof ApplicationPreparedEvent) {
                System.out.println("ApplicationPreparedEvent");
            } else if (applicationEvent instanceof ApplicationStartedEvent) {
                System.out.println("ApplicationStartedEvent");
            } else if (applicationEvent instanceof ApplicationReadyEvent) {
                System.out.println("ApplicationReadyEvent");
            } else if (applicationEvent instanceof ApplicationFailedEvent) {
                System.out.println("ApplicationFailedEvent");
            }
        });
        springApplication.run();
    }

}

