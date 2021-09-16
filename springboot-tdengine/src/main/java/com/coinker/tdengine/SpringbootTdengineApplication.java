package com.coinker.tdengine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.coinker.tdengine.dao"})
@SpringBootApplication
public class SpringbootTdengineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTdengineApplication.class, args);
    }

}
