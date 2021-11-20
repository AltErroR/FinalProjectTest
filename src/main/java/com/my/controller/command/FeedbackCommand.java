package com.my.controller.command;

import com.my.controller.service.implementation.FeedbackServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(FeedbackCommand.class);
    FeedbackServiceImpl feedbackServiceImplementation= new FeedbackServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to get all feedbacks");
        return feedbackServiceImplementation.feedbackInit(request,response);
    }
}
