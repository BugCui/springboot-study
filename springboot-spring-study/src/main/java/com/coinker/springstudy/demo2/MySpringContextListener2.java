package com.coinker.springstudy.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Cui Shenpeng
 * @Date 2021/9/2 17:29
 */
public class MySpringContextListener2 implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MySpringContextListener2.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        logger.info("$$$ MySpringContextListener.onApplicationEvent() exc.....$$222");
    }

}
