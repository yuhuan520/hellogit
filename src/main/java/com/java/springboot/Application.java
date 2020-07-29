package com.java.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: springBoot_emp
 * @description: 启动类
 * @author: Mr.Yu
 * @create: 2020-07-28 16:13
 **/
@SpringBootApplication(scanBasePackages = "com.java.springboot.*")
@MapperScan(basePackages = "com.java.springboot.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
