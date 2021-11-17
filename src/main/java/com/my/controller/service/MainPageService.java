package com.my.controller.service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MainPageService {
     String mainPageInitialization(String query,HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException;

}
