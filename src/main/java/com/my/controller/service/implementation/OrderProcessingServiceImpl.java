package com.my.controller.service.implementation;

import com.my.controller.service.OrderProcessingService;
import com.my.dao.DaoFactory;
import com.my.dao.OrderDao;
import com.my.dao.ServiceDao;
import com.my.dao.UserDao;
import com.my.dao.mysql.MySqlDaoFactory;
import com.my.dao.mysql.MySqlOrderDao;
import com.my.dao.mysql.MySqlServiceDao;
import com.my.dao.mysql.MySqlUserDao;
import com.my.entity.Order;
import com.my.entity.Service;
import com.my.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.my.constants.Constants.*;


public class OrderProcessingServiceImpl implements OrderProcessingService {
    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingServiceImpl.class);
    DaoFactory daoFactory= new MySqlDaoFactory();
    OrderDao mySqlOrderDao= daoFactory.getOrderDao();
    UserDao mySqlUserDao = daoFactory.getUserDao();
    ServiceDao mySqlServiceDao = daoFactory.getServiceDao();

    @Override
    public String updateOrder(HttpServletRequest request, HttpServletResponse response) {
        String time =request.getParameter(TIME);
        String date =request.getParameter(DATE);
        int orderId =Integer.parseInt(request.getParameter(ORDER_ID));
        String typeOfUpdate = request.getParameter(STATUS);
        if(typeOfUpdate.equals(DELETE)){
            mySqlOrderDao.deleteOrder(orderId);
            logger.debug("order deleted");
        }
        if(typeOfUpdate.equals(UPDATE)){
            Order order = mySqlOrderDao.getOrder(orderId);
            mySqlOrderDao.updateOrder(orderId,order.getMasterLogin(),order.getUserId(),
                    order.getServiceName(),time,date,order.getStatus());
            logger.debug("order updated");
        }
        logger.debug("succes.jsp");
        return SUCCESS_JSP;
    }

    @Override
    public String payOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int orderId =Integer.parseInt(request.getParameter(ORDER_ID));
            Order order = mySqlOrderDao.getOrder(orderId);
            User user = mySqlUserDao.getUser(order.getUserId());
            Service service = mySqlServiceDao.getService(order.getServiceName());
            user.setWallet(user.getWallet()-service.getPrice());
            if (user.getWallet()<0){
                logger.warn("wallet < price");
                throw new Exception("Not Enought Money");
            }
            mySqlOrderDao.updateOrder(orderId,order.getMasterLogin(),order.getUserId(),
                    order.getServiceName(),order.getTimeSlot(),order.getDateSlot(),PAID);
            mySqlUserDao.updateUser(user.getId(), user.getWallet());
        logger.debug("order payment done");
        return SUCCESS_JSP;
    }

    @Override
    public String updateStatus(HttpServletRequest request, HttpServletResponse response) {
        String status = request.getParameter(STATUS);
        int id =Integer.parseInt(request.getParameter(ORDER_ID));
        Order order= mySqlOrderDao.getOrder(id);
        mySqlOrderDao.updateOrder(id,order.getMasterLogin(), order.getUserId(), order.getServiceName(),
                order.getTimeSlot(),order.getDateSlot(),status);
        logger.debug("status updated");
        return SUCCESS_JSP;
    }

    @Override
    public String getUserOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= mySqlOrderDao.getAllOrders4User((int)request.getSession().getAttribute(USER_ID));
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return WRITE_FEEDBACK_JSP;
    }

    @Override
    public String getMasterOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= mySqlOrderDao.getAllOrders4Master(request.getSession().getAttribute(USER_LOGIN).toString());
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return MASTER_HOME_JSP;
    }

    @Override
    public String getAdminOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= mySqlOrderDao.getAllOrders4Admin();
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return ADMIN_HOME_JSP;
    }

    @Override
    public String getPaymentOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= mySqlOrderDao.getAllOrders4Payment();
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return GET_PAYMENT_JSP ;
    }
}
