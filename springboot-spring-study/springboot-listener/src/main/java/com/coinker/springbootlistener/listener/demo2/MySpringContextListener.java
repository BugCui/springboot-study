package com.coinker.springbootlistener.listener.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Cui Shenpeng
 * @Date 2021/9/2 17:29
 */
public class MySpringContextListener implements ApplicationListener<ApplicationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MySpringContextListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.info("$$$ MySpringContextListener.onApplicationEvent() exc.....");
    }

}
