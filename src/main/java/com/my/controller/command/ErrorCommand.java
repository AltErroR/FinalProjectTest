package com.my.controller.command;

import com.my.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(ErrorCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("redirect to main page from error.jsp");
        return "/FPT/controller?command=mainPage";
    }
}
