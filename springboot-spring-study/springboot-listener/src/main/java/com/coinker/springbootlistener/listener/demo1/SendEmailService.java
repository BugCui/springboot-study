package com.coinker.springbootlistener.listener.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Cui Shenpeng
 * @Classname SendEmailService
 * @Description 测试发用邮件
 * @Date 2021/9/2 18:46
 */

@Component
public class SendEmailService {

    private EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);

    public SendEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "*/15 * * * * ?")
    public void send(){
        // 显示调用
        emailService.sendEmail("known.spammer@example.org", "test...");
        logger.info("$$$$$$$$$$$$$$$$$$ SendEmailService");
    }
}
