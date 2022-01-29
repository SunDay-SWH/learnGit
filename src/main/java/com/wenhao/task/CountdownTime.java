package com.wenhao.task;

import com.wenhao.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CountdownTime {
    private final SendMailService sendMailService;
    public CountdownTime(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }
    private int i = 0;

    @Scheduled(cron = "0/5 * * * * ?")
    public void startSend() {
        sendMailService.sendMail();
        log.info("已发送: " + ++i + "封");
    }
}
