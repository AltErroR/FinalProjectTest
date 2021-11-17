package com.my.dao;

import com.my.entity.Order;

import java.sql.Date;
import java.util.List;

public interface OrderDao {
    boolean createOrder(String masterLogin, int userId, String serviceName, String timeSlot, String  dateSlot);
    boolean updateOrder(int id, String masterLogin, int userId,String serviceName,
                        String timeSlot, String dateSlot,String status);
    Order getOrder(int id);
    Order getOrder(String masterLogin,String date,String time, String serviceName);
    List<Order> getAllOrders4User(int userId);
    List<Order> getAllOrders4Master(String masterLogin);
    List<Order> getAllOrders4Admin();
    List<Order> getAllOrders4Payment();
    boolean deleteOrder(int id);
    List<Order> getAllOrders();
}
