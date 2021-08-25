package com.coinker.study.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * spring 重试机制学习
 * @author Administrator
 */
@SpringBootApplication
@EnableRetry
public class SpringbootSpringRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringRetryApplication.class, args);
    }

}
