package com.coinker.springstudy.listener.demo1;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * @author Cui Shenpeng
 * @Date 2021/9/2 18:28
 * @Desc: 发布自定义事件
 */
public class EmailService implements ApplicationEventPublisherAware {

    private List<String> blockedList;
    private ApplicationEventPublisher publisher;

    public void setBlockedList(List<String> blockedList) {
        this.blockedList = blockedList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            /*
             * 主动触发一个事件
             * 默认情况下，事件侦听器会同步接收事件。这意味着该publishEvent()方法会阻塞，直到所有侦听器都完成对事件的处理
             */
            publisher.publishEvent(new BlockedListEvent(this, address, content));
        }
        // send email...
    }
}
