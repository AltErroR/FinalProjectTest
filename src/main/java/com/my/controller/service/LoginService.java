package com.my.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    String login(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
