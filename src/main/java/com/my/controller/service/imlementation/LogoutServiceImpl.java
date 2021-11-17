package com.my.controller.service.imlementation;

import com.my.controller.Controller;
import com.my.controller.service.LogoutService;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServiceImpl implements LogoutService {
    private static final Logger logger = LoggerFactory.getLogger(LogoutServiceImpl.class);
    @Override
    public String exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getSession().invalidate();
        logger.info("success");
        return "/controller?command=mainPage";
    }
}
