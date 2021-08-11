package com.huawei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author lizhe
 * @date 2021-08-11 09:00
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.huawei.mapper"})
@EnableCaching
public class SpringbootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApp.class,args);
    }
}
