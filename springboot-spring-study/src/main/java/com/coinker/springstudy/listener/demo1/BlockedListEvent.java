package com.coinker.springstudy.listener.demo1;

import org.springframework.context.ApplicationEvent;

/**
 * @author Cui Shenpeng
 * @Date 2021/9/2 18:27
 * @Desc: 这是一个自定义事件
 */
public class BlockedListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlockedListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    // accessor and other methods...
}
