package com.my.controller.service.imlementation;

import com.my.controller.service.OrderProcessingService;
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


public class OrderProcessingServiceImpl implements OrderProcessingService {
    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingServiceImpl.class);
    MySqlOrderDao mySqlOrderDao = new MySqlOrderDao();
    MySqlUserDao mySqlUserDao = new MySqlUserDao();
    MySqlServiceDao mySqlServiceDao = new MySqlServiceDao();
    @Override
    public String updateOrder(HttpServletRequest request, HttpServletResponse response) {
        String time =request.getParameter("time");
        String date =request.getParameter("date");
        int orderId =Integer.parseInt(request.getParameter("orderId"));
        String typeOfUpdate = request.getParameter("status");
        if(typeOfUpdate.equals("delete")){
            mySqlOrderDao.deleteOrder(orderId);
            logger.debug("order deleted");
        }
        if(typeOfUpdate.equals("update")){
            Order order = mySqlOrderDao.getOrder(orderId);
            mySqlOrderDao.updateOrder(orderId,order.getMasterLogin(),order.getUserId(),
                    order.getServiceName(),time,date,order.getStatus());
            logger.debug("order updated");
        }
        logger.debug("succes.jsp");
        return "view/success.jsp";
    }

    @Override
    public String payOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int orderId =Integer.parseInt(request.getParameter("orderId"));
            Order order = mySqlOrderDao.getOrder(orderId);
            User user = mySqlUserDao.getUser(order.getUserId());
            Service service = mySqlServiceDao.getService(order.getServiceName());
            user.setWallet(user.getWallet()-service.getPrice());
            if (user.getWallet()<0){
                logger.warn("wallet < price");
                throw new Exception("Not Enought Money");
            }
            mySqlOrderDao.updateOrder(orderId,order.getMasterLogin(),order.getUserId(),
                    order.getServiceName(),order.getTimeSlot(),order.getDateSlot(),"paid");
            mySqlUserDao.updateUser(user.getId(), user.getWallet());
        logger.debug("order payment done");
        return "view/success.jsp";
    }

    @Override
    public String updateStatus(HttpServletRequest request, HttpServletResponse response) {
        String status = request.getParameter("status");
        int id =Integer.parseInt(request.getParameter("orderId"));
        Order order= mySqlOrderDao.getOrder(id);
        mySqlOrderDao.updateOrder(id,order.getMasterLogin(), order.getUserId(), order.getServiceName(),
                order.getTimeSlot(),order.getDateSlot(),status);
        logger.debug("status updated");
        return "view/success.jsp";
    }

    @Override
    public String getUserOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList= mySqlOrderDao.getAllOrders4User((int)request.getSession().getAttribute("userId"));
        request.setAttribute("ordersList",ordersList);
        logger.debug("success");
        return "view/writeFeedback.jsp";
    }

    @Override
    public String getMasterOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList= mySqlOrderDao.getAllOrders4Master(request.getSession().getAttribute("userLogin").toString());
        request.setAttribute("ordersList",ordersList);
        logger.debug("success");
        return "view/masterHome.jsp";
    }

    @Override
    public String getAdminOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList= mySqlOrderDao.getAllOrders4Admin();
        request.setAttribute("ordersList",ordersList);
        logger.debug("success");
        return "view/adminHome.jsp";
    }

    @Override
    public String getPaymentOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList= mySqlOrderDao.getAllOrders4Payment();
        request.setAttribute("ordersList",ordersList);
        logger.debug("success");
        return "view/getPayment.jsp";
    }
}
