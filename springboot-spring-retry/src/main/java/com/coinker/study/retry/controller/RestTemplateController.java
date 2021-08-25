package com.coinker.study.retry.controller;

import com.alibaba.fastjson.JSON;
import com.coinker.study.retry.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping(value = "/rest")
public class RestTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateController.class);

    @Autowired
    private RestTemplateService restTemplateService;


    /**
     * @Retryable 注解的方法在发生异常时会重试，参数说明：
     * value：当指定异常发生时会进行重试 ,HttpClientErrorException是RestClientException的子类。如果所有异常都进行重试，改成Exception.class。
     * include：和value一样，默认空。如果 exclude也为空时，所有异常都重试
     * exclude：指定异常不重试，默认空。如果 include也为空时，所有异常都重试
     * maxAttemps：最大重试次数，默认3
     * backoff：重试等待策略，默认空
     * =========================================
     * @Backoff 注解为重试等待的策略，参数说明：
     * delay：指定重试的延时时间，默认为1000毫秒
     * multiplier：指定延迟的倍数，比如设置delay=5000，multiplier=2时，第一次重试为5秒后，第二次为10(5x2)秒，第三次为20(10x2)秒。
     */
    @RequestMapping(value = "/restTemplate")
    @Retryable(value = Exception.class, maxAttempts = 3,
            backoff = @Backoff(delay = 5000L, multiplier = 2))
    public Object findStateByStateFromPackageService() {
        logger.info("发起远程API请求");

        String response = this.restTemplateService.doSomeThing();

        logger.info("Rest请求数据:" + response);
        return JSON.parse(response);
    }

    @GetMapping("/retry")
    public String getNum() throws Exception {
        int i = restTemplateService.minGoodsnum(-1);
        System.out.println("====" + i);
        return "succeess";
    }

}
