package com.elect.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    public static void sendMail(String to,String content){
    //收件人邮箱地址
    String from = "xqq.888@qq.com";
    //邮件的主题
    String subject="验证码";
    //连接服务器的参数配置
    Properties props = new Properties();
    //设置邮件的使用协议 SMTP /pop3
		props.setProperty("mail.transport.protocol", "smtp");
    //设置SMTP的服务器地址
		props.setProperty("mail.smtp.host", "smtp.qq.com");
    //请求认证
		props.setProperty("mail.smtp.auth", "true");
    //创建session实例对象
    Session session= Session.getInstance(props);
    //创建MimeMessage对象实例
    MimeMessage message= new  MimeMessage(session);
		try {
        //设置发件人信息
        message.setFrom( new InternetAddress(from));
        //设置收件人信息,可以添加多个收件人
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        //设置发送的时间
        message.setSentDate(new Date());
        //设置发送的主题
        message.setSubject(subject);
        //设置发送的正文内容
        message.setText(content);
        //保存邮件内容信息
        message.saveChanges();
        //开始起debug
        session.setDebug(true);
        //获取transport对象
        Transport transport=session.getTransport("smtp");
        //设置邮件发送的授权码,password非用户密码，为邮件第三方授权码
        transport.connect(from, "tcjzcrrvssdphjge");
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //关闭
        transport.close();
    } catch (AddressException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}
}
