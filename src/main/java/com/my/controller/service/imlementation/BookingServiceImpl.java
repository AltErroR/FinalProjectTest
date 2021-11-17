package com.my.controller.service.imlementation;

import com.my.controller.command.BookingCommand;
import com.my.controller.service.BookingService;
import com.my.dao.mysql.MySqlOrderDao;
import com.my.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
        return "view/success.jsp";
    }
}
