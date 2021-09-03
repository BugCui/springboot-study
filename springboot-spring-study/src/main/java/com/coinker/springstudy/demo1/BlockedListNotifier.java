package com.coinker.springstudy.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * @author Cui Shenpeng
 * @Classname BlockedListNotifier
 * @Description 接收自定义事件
 * @Date 2021/9/2 18:33
 */
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BlockedListNotifier.class);

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        logger.info("### {} get an email event,source address{},source content{}", notificationAddress, event.getAddress(), event.getContent());
    }
}