package com.my.controller.command;

import com.my.controller.service.implementation.OrderProcessingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MasterHomeInitCommand implements  Command{
    private static final Logger logger = LoggerFactory.getLogger(MasterHomeInitCommand.class);
    OrderProcessingServiceImpl orderProcessingService= new OrderProcessingServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to get orders to change status for current master");
        return orderProcessingService.getMasterOrders(request, response);

    }
}
