package com.lerh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lerh.dao")
public class LerhApplication {
    public static void main(String[] args) {
        SpringApplication.run(LerhApplication.class, args);
    }

}
