package com.my.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AccountCreationService {
    String creation(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
