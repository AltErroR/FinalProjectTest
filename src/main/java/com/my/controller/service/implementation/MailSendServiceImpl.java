package com.my.controller.service.implementation;

import com.my.controller.service.MailSendService;
import com.my.dao.AccountDao;
import com.my.dao.DaoFactory;
import com.my.dao.OrderDao;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlDaoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.*;

import static com.my.constants.Constants.*;

public class MailSendServiceImpl implements MailSendService {
    private static final Logger logger = LoggerFactory.getLogger(MailSendServiceImpl.class);
    DaoFactory daoFactory= new MySqlDaoFactory();
    AccountDao mySqlAccountDao= daoFactory.getAccountDao();
    List<String> mails= new ArrayList<>();

    @Override
    public void sendMail() throws IOException, MessagingException{

        logger.debug("try to send mail");
        mails= mySqlAccountDao.getAllMails();
        final Properties properties= new Properties();
        properties.load(MainPageServiceImpl.class.getClassLoader().getResourceAsStream(MAIL_PROPERTIES));
        Session mailSession= Session.getDefaultInstance(properties);
        MimeMessage message= new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(SALON_EMAIL));
        for(String mail:mails){
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(mail));
        }
        message.setSubject(SALON_NAME);
        message.setText(MAIL_MESSAGE);

        Transport tr = mailSession.getTransport();
        tr.connect(null,MAIL_PASSWORD);
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
        logger.debug("success");
    }

}
