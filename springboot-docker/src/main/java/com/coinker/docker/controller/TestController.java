package com.coinker.docker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cui Shenpeng
 * @Classname TestController
 * @Description TODO
 * @Date 2021/6/11 9:48
 */

@RestController
public class TestController {

    Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("这是控制台日志！");
        log.info("这是输出到文件的日志");
        return "HELLO-BUG！！！！！！！！！！";
    }

}
