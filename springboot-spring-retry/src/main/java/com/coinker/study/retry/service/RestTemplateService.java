package com.coinker.study.retry.service;

import com.coinker.study.retry.controller.RestTemplateController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author Cui Shenpeng
 * @Classname RestTemplateService
 * @Date 2021/8/25 12:07
 */
@Service
public class RestTemplateService {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateService.class);


    public String doSomeThing() {
        System.out.println("调用服务@@@@@@@@@@@@@@@@@");
        int i = 1 / 0;
        return "SUCCESS";
    }

    private final int totalNum = 53;

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public int minGoodsnum(int num) throws Exception {
        log.info("减库存开始" + LocalTime.now());
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("illegal operation");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        log.info("减库存执行结束" + LocalTime.now());
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e) {
        log.warn("[recover method]减库存失败！！！" + LocalTime.now());
        //记日志到数据库
        //发送异常的邮件通知
        return totalNum;
    }



}
