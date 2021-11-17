package com.my.controller.service.imlementation;

import com.my.controller.service.MailSendService;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlOrderDao;
import com.my.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class MailSendServiceImpl implements MailSendService {
    private static final Logger logger = LoggerFactory.getLogger(MailSendServiceImpl.class);
    MySqlAccountDao mySqlAccountDao= new MySqlAccountDao();
    MySqlOrderDao mySqlOrderDao = new MySqlOrderDao();
    List<Order> orders= new ArrayList<>();
    List<String> mails= new ArrayList<>();

    @Override
    public void sendMail() throws IOException, MessagingException, ParseException {

        logger.debug("try to send mail");
        mails= mySqlAccountDao.getAllMails();
        final Properties properties= new Properties();
        properties.load(MainPageServiceImpl.class.getClassLoader().getResourceAsStream("mail.properties"));
        Session mailSession= Session.getDefaultInstance(properties);
        MimeMessage message= new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("b24963@gmail.com"));
        for(String mail:mails){
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(mail));
        }
        message.setSubject("Beauty Salon");
        message.setText("Leave feedback please");

        Transport tr = mailSession.getTransport();
        tr.connect(null,"123456B_o");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
        logger.debug("success");
    }

}
