package com.my.controller.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface OrderProcessingService {
    String updateOrder(HttpServletRequest request, HttpServletResponse response);
    String updateStatus(HttpServletRequest request, HttpServletResponse response);
    String payOrder(HttpServletRequest request, HttpServletResponse response) throws Exception;
    String getUserOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    String getMasterOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    String getAdminOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    String getPaymentOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
