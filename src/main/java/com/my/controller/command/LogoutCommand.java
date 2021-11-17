package com.my.controller.command;

import com.my.controller.service.imlementation.LogoutServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(LogoutCommand.class);
LogoutServiceImpl logoutService = new LogoutServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to log out");
    return logoutService.exit(request,response);
    }
}
