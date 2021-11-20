package com.my.listener;

import com.my.controller.service.implementation.MailSendServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Mailer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Mailer.class);
    MailSendServiceImpl mailSendService = new MailSendServiceImpl();

    @Override
    public void run() {
        try {
            mailSendService.sendMail();
            Thread.sleep(86400000);
        } catch (Exception e) {
            logger.error("mailer error occured");
        }
    }
}
