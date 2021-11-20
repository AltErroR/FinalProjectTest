package com.my.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.Constants.MAIN_PAGE_COMMAND;

public class ErrorCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(ErrorCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("redirect to main page from error.jsp");
        return MAIN_PAGE_COMMAND;
    }
}
