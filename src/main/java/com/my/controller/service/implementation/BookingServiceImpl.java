package com.my.controller.service.implementation;

import com.my.controller.service.BookingService;
import com.my.dao.mysql.MySqlOrderDao;
import com.my.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.my.constants.Constants.SUCCESS_JSP;


public class BookingServiceImpl implements BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    MySqlOrderDao mySqlOrderDao= new MySqlOrderDao();
    @Override
    public String booking(String dateSlot,String timeSlot,String masterLogin,String serviceName,int userId) throws Exception {

        Order order= mySqlOrderDao.getOrder(masterLogin, dateSlot, timeSlot, serviceName);
        if(order!=null)
        {
            logger.debug("reservation failed");
            throw new Exception("Already reserved");
        }
        mySqlOrderDao.createOrder(masterLogin,userId,serviceName,timeSlot,dateSlot);
        logger.debug("reservation done");
        return SUCCESS_JSP;
    }
}
