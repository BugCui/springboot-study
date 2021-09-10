package com.coinker.springbootlistener.listener.demo3;

import com.coinker.springbootlistener.listener.demo1.BlockedListEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Cui Shenpeng
 * @Classname BlockedListNotifier
 * @Description 基于注解的监听器
 * @Date 2021/9/3 9:45
 */
public class BlockedListNotifier2 {

    private static final Logger logger = LoggerFactory.getLogger(BlockedListNotifier2.class);

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener
    public void processBlockedListEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        logger.info("###222 {} get an email event,source address{},source content{}", notificationAddress, event.getAddress(), event.getContent());
    }

    /**
     * 侦听多个时间
     */
    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void handleContextStart() {
        // ...
    }

    /**
     * 事件链，返回一个事件
     */
    @EventListener
    public ContextRefreshedEvent handleBlockedListEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress and
        // then publish a ListUpdateEvent...
        return new ContextRefreshedEvent(new GenericApplicationContext());
    }

    /**
     * 异步事件监听器
     */
    @EventListener
    @Async
    public void processBlockedListEvent2(BlockedListEvent event) {
        // BlockedListEvent is processed in a separate thread
    }

    /**
     * 在另一个侦听器之前调用一个侦听器
     */
    @EventListener
    @Order(42)
    public void processBlockedListEvent3(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
    }

    /**
     * 使用泛型进一步定义事件的结构
     */
    @EventListener
    public void onPersonCreated(EntityCreatedEvent<Person> event) {
        // ...
    }

    public class EntityCreatedEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
        public EntityCreatedEvent(T entity) {
            super(entity);
        }

        @Override
        public ResolvableType getResolvableType() {
            return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
        }
    }

    class Person {

    }
}
