package com.my.controller.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface LogoutService {
    String exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

