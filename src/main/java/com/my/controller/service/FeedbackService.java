package com.my.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FeedbackService {
    String feedbackInit(HttpServletRequest request, HttpServletResponse response) throws Exception;
    String feedbackWrite(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
