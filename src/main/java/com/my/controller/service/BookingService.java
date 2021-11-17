package com.my.controller.service;

public interface BookingService {
    String booking(String dateSlot,String timeSlot,String masterLogin,String serviceName,int userId) throws Exception;
}
