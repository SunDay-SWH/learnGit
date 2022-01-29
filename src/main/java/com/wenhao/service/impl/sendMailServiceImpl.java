package com.wenhao.service.impl;

import com.wenhao.service.SendMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class sendMailServiceImpl implements SendMailService {
    private final JavaMailSender javaMailSender;
    public sendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    //发送人
    @Value("${spring.mail.username}")
    private String from;
    //接收人
    @Value("${tomails:}")
    private String[] xjj;
    //标题
    private String subject = "小犟犟月历牌";
    //正文
    private String context;

    @Override
    public void sendMail() {
        context = "孙文昊为您倒计时:\n\n"+transForDate();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(小甜甜)");
        message.setTo(xjj);
        message.setSubject(subject);
        message.setText(context);

        javaMailSender.send(message);
    }


    @Override
    public String transForDate() {
        Date _now = new Date();
        String context = "现在是北京时间: ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String now = sdf.format(_now);
        context += now+"\n\n\n";
        Date springFestive = null;
        try {
            springFestive = sdf.parse("2022年02月01日 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long mss = springFestive.getTime() - _now.getTime();
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        context+="春节倒计时: "+days + " 天 " + hours + " 小时 " + minutes + " 分 "
                + seconds + " 秒 ";
        return context;
    }
}

















