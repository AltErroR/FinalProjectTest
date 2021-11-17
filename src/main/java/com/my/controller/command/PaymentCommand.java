package com.my.controller.command;

import com.my.controller.service.imlementation.OrderProcessingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentCommand implements Command
{
    private static final Logger logger = LoggerFactory.getLogger(PaymentCommand.class);
    OrderProcessingServiceImpl orderProcessingService= new OrderProcessingServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to get orders ready for payment");
        return orderProcessingService.getPaymentOrders(request, response);
    }
}
