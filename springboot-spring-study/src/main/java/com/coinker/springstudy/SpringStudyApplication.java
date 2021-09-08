package com.coinker.springstudy;

import com.coinker.springstudy.listener.demo1.EmailService;
import com.coinker.springstudy.listener.demo2.MySpringContextListener;
import com.coinker.springstudy.listener.demo2.MySpringContextListener2;
import com.coinker.springstudy.listener.demo3.BlockedListNotifier2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableScheduling // 开 启定时任务功能
public class SpringStudyApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringStudyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }

    @Bean
    public MySpringContextListener createListener() {
        return new MySpringContextListener();
    }

    @Bean
    public MySpringContextListener2 createListener2() {
        return new MySpringContextListener2();
    }

 /*   @Bean
    public BlockedListNotifier createNotifier() {
        BlockedListNotifier blockedListNotifier = new BlockedListNotifier();
        blockedListNotifier.setNotificationAddress("blockedlist@example.org");
        return blockedListNotifier;
    }*/

    @Bean
    public BlockedListNotifier2 createNotifier2() {
        BlockedListNotifier2 blockedListNotifier = new BlockedListNotifier2();
        blockedListNotifier.setNotificationAddress("blockedlist2@example.org");
        logger.info("$$$$$$$$$$$$$$$$$$ createNotifier2");
        return blockedListNotifier;
    }

    @Bean
    public EmailService createEmailService() {
        EmailService emailService = new EmailService();
        List<String> blockedList = new ArrayList<>();
        blockedList.add("known.spammer@example.org");
        blockedList.add("known.hacker@example.org");
        blockedList.add("john.doe@example.org");
        emailService.setBlockedList(blockedList);
        return emailService;
    }

}
