package com.my.dao.mysql;

import com.my.dao.DBManager;
import com.my.dao.OrderDao;
import com.my.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class  MySqlOrderDao implements OrderDao {
    private static final Logger logger = LoggerFactory.getLogger(MySqlOrderDao.class);
    @Override
    public boolean createOrder(String masterLogin, int userId, String serviceName, String timeSlot, String  dateSlot) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_ORDER);
            ps.setInt(1,userId);
            ps.setString(2,masterLogin);
            ps.setString(3,timeSlot);
            ps.setDate(4,adaptStr2Date(dateSlot));
            ps.setString(5,serviceName);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("order creation failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateOrder(int id, String masterLogin, int userId, String serviceName,
                               String timeSlot, String  dateSlot,String status) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_ORDER);
            ps.setInt(1,userId);
            ps.setString(2,masterLogin);
            ps.setString(3,serviceName);
            ps.setString(4,timeSlot);
            ps.setDate(5,adaptStr2Date(dateSlot));
            ps.setString(6,status);
            ps.setInt(7,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("order update failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ORDER);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no order data");
                return null;}
            order= new Order(rs.getInt(1),rs.getString(2),rs.getInt(6));
            order.setDateSlot(adaptDate2Str(rs.getDate(5)));
            order.setTimeSlot(rs.getString(4));
            order.setServiceName(rs.getString(3));
            order.setStatus(rs.getString(7));

        } catch (Exception e) {
            logger.error("order extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return order;
    }
    @Override
    public Order getOrder(String masterLogin,String date,String time, String serviceName) {
        Order order = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ORDER_WITHOUT_ID);
            ps.setString(1, serviceName);
            ps.setString(2, time);
            ps.setString(3, masterLogin);
            ps.setDate(4, adaptStr2Date(date));
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.error("no order data");
                return null;}
            order= new Order(rs.getInt(1),rs.getString(2),rs.getInt(6));
            order.setDateSlot(adaptDate2Str(rs.getDate(5)));
            order.setTimeSlot(rs.getString(4));
            order.setServiceName(rs.getString(3));
            order.setStatus(rs.getString(7));

        } catch (Exception e) {
            logger.error("order extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return order;
    }

    @Override
    public boolean deleteOrder(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_ORDER);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("delete order failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }


    @Override
    public List<Order> getAllOrders4User(int userId)
    {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ORDERS_FOR_USER);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            ordersExtract(orders, rs);
        } catch (Exception e) {
            logger.error("order list extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return orders;

    }

    @Override
    public List<Order> getAllOrders4Master(String masterLogin)
    {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ORDERS_FOR_MASTER);
            ps.setString(1,masterLogin);
            rs = ps.executeQuery();
            ordersExtract(orders, rs);
        } catch (Exception e) {
            logger.error("order list extraction for master failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return orders;

    }
    @Override
    public List<Order> getAllOrders4Admin()
    {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_RESERVED_ORDERS);
            rs = ps.executeQuery();
            ordersExtract(orders, rs);
        } catch (Exception e) {
            logger.error("order list extraction for admin failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return orders;

    }

    @Override
    public List<Order> getAllOrders4Payment()
    {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_DONE_ORDERS);
            rs = ps.executeQuery();
            ordersExtract(orders, rs);
        } catch (Exception e) {
            logger.error("order list extraction for payment failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return orders;

    }

    private void ordersExtract(List<Order> orders, ResultSet rs) throws SQLException {
        Order order;
        while(rs.next())
        {
            order= new Order(rs.getInt(1),rs.getString(2),rs.getInt(6));
            order.setDateSlot(adaptDate2Str(rs.getDate(5)));
            order.setTimeSlot(rs.getString(4));
            order.setServiceName(rs.getString(3));
            order.setStatus(rs.getString(7));
            orders.add(order);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Order> orders= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ORDER_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                orders.add(getOrder(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("order list extraction failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return orders;
    }

    private Date adaptStr2Date(String date){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date utilDate =new java.util.Date();
        try {
            utilDate = format.parse(date);
        } catch (ParseException e) {
            logger.error("unable to convert String 2 Date");
            e.printStackTrace();
        }
        return new Date(utilDate.getTime());
    }
    private String adaptDate2Str(Date date) {
        StringBuilder sb= new StringBuilder();
        String[] dateStr =date.toString().split("-");
        for (int i=2;i>-1;i--){
            sb.append(dateStr[i]).append('.');
        }
        return sb.substring(0, sb.length()-1);

    }
}
