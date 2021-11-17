package com.my.controller.command;

import com.my.controller.Controller;
import com.my.controller.service.imlementation.BookingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookingCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(BookingCommand.class);
    BookingServiceImpl bookingServiceImplementation= new BookingServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("Try to make reservation");
        HttpSession session = request.getSession();
        String dateSlot= request.getParameter("date");
        String timeSlot= request.getParameter("time");
        String masterLogin= request.getParameter("master");
        String serviceName= request.getParameter("service");
        int userId =(int) session.getAttribute("userId");
        return bookingServiceImplementation.booking(dateSlot,timeSlot,masterLogin,serviceName,userId);
    }
}
