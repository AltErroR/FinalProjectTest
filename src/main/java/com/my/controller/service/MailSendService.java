package com.my.controller.service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;

public interface MailSendService{
    void sendMail() throws IOException, MessagingException, ParseException;
}
