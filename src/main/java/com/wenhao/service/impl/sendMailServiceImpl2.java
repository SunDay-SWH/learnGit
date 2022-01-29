package com.wenhao.service.impl;

import com.wenhao.service.SendMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

//@Service
public class sendMailServiceImpl2 implements SendMailService {
    private final JavaMailSender javaMailSender;

    public sendMailServiceImpl2(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    //发送人
    private String from = "2237370080@qq.com";
    //接收人
    private String to = "sunwenhao_id@icloud.com";
    private String xjj = "2270666837@qq.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "<img src='https://img.tt98.com/d/file/96kaifa/201906271456147/008.jpg'/>";

    @Override
    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(xjj);
            helper.setSubject(subject);
            helper.setText(context,true);

            //添加附件
//            File f1 = new File("/Users/sunwenhao/Documents/IntelliJ IDEA/SpringBoot/springboot_23_mail/target/springboot_23_mail-0.0.1-SNAPSHOT.jar");
            File f2 = new File("/Users/sunwenhao/Documents/IntelliJ IDEA/SpringBoot/springboot_23_mail/src/main/resources/face.jpeg");
            File f3 = new File("/Users/sunwenhao/Documents/IntelliJ IDEA/SpringBoot/springboot_23_mail/src/main/resources/ge.jpeg");
            File f4 = new File("/Users/sunwenhao/Documents/IntelliJ IDEA/SpringBoot/springboot_23_mail/src/main/resources/time.png");

//            helper.addAttachment(f1.getName(),f1);
            helper.addAttachment("最靠谱的培训机构.jpeg",f2);
            helper.addAttachment(f3.getName()+".jpeg", f3);
            helper.addAttachment(f4.getName()+".png", f4);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String transForDate() {
        return null;
    }
}
