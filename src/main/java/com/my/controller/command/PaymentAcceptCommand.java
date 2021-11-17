package com.my.controller.command;

import com.my.controller.service.imlementation.OrderProcessingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentAcceptCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(PaymentAcceptCommand.class);
    OrderProcessingServiceImpl orderProcessingService= new OrderProcessingServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to make payment");
        return  orderProcessingService.payOrder(request,response);
    }
}