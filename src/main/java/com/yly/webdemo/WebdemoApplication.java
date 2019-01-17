package com.yly.webdemo;

import com.yly.webdemo.util.RedisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties(YmlProTest.class)
@MapperScan("com.yly.webdemo.mapper")
public class WebdemoApplication {

    private static Logger logger = LoggerFactory.getLogger(WebdemoApplication.class);

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebdemoApplication.class);
        springApplication.addListeners((ApplicationListener<ApplicationEvent>) applicationEvent -> {
            if (applicationEvent instanceof ApplicationStartingEvent) {
                logger.info("ApplicationStartingEvent");
            } else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
                logger.info("ApplicationEnvironmentPreparedEvent");
            } else if (applicationEvent instanceof ApplicationPreparedEvent) {
                logger.info("ApplicationPreparedEvent");
            } else if (applicationEvent instanceof ApplicationStartedEvent) {
                logger.info("ApplicationStartedEvent");
            } else if (applicationEvent instanceof ApplicationReadyEvent) {
                logger.info("ApplicationReadyEvent");
            } else if (applicationEvent instanceof ApplicationFailedEvent) {
                logger.info("ApplicationFailedEvent");
            }
        });
        springApplication.run();
    }

}

