package com.my.listener;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    Mailer mailer= new Mailer();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("try to start mailer 1 time per day");
//        mailer.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        mailer.interrupt();
    }

}
