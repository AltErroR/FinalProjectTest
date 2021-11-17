package com.my.controller.command;

import com.my.controller.service.imlementation.LoginServiceImpl;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(LoginCommand.class);
    LoginServiceImpl loginServiceImplementation= new LoginServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to login");
        return loginServiceImplementation.login(request,response);
    }
}
