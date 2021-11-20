package com.my.controller.service;

import com.my.controller.service.implementation.OrderProcessingServiceImpl;
import com.my.dao.mysql.MySqlOrderDao;
import com.my.dao.mysql.MySqlServiceDao;
import com.my.dao.mysql.MySqlUserDao;
import com.my.entity.Order;
import com.my.entity.Service;
import com.my.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static com.my.constants.Constants.*;
import static org.mockito.Mockito.*;


public class OrderProcessingServiceImplTest {


    @Mock
    private MySqlOrderDao mySqlOrderDaoMock ;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private Order orderMock;
    @Mock
    private HttpSession sessionMock;
    @Mock
    private Service serviceMock ;
    @Mock
    private MySqlServiceDao mySqlServiceDaoMock;
    @Mock
    private MySqlUserDao mySqlUserDaoMock;
    @Mock
    private User userMock;

    @InjectMocks
    private OrderProcessingServiceImpl testingInstance;


    @Test
    public void shouldUpdateOrder(){
        MockitoAnnotations.initMocks(this);
        when(requestMock.getParameter(DATE)).thenReturn("1.1.1");
        when(requestMock.getParameter(TIME)).thenReturn("1:1");
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(requestMock.getParameter(STATUS)).thenReturn(UPDATE);
        when(mySqlOrderDaoMock.getOrder(1)).thenReturn(orderMock);
        when(mySqlOrderDaoMock.updateOrder(1,"l",1,"s","1:1","1.1.1","reserved")).thenReturn(true);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.updateOrder(requestMock,responseMock));
    }

    @Test
    public void shouldPayOrder() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(mySqlOrderDaoMock.getOrder(anyInt())).thenReturn(orderMock);
        when(orderMock.getUserId()).thenReturn(1);
        when(orderMock.getServiceName()).thenReturn("a");
        when(mySqlUserDaoMock.getUser(anyInt())).thenReturn(userMock);
        when(mySqlServiceDaoMock.getService(anyString())).thenReturn(serviceMock);
        when(userMock.getWallet()).thenReturn(12);
        when(serviceMock.getPrice()).thenReturn(3);
        when(mySqlOrderDaoMock.updateOrder(anyInt(),anyString(),anyInt(),anyString(),anyString(),anyString(),anyString())).thenReturn(true);
        when(mySqlUserDaoMock.updateUser(anyInt(),anyInt())).thenReturn(true);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.payOrder(requestMock,responseMock));
    }

    @Test
    public void shouldUpdateStatus(){
        MockitoAnnotations.initMocks(this);
        when(requestMock.getParameter(STATUS)).thenReturn("reserved");
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(mySqlOrderDaoMock.getOrder(1)).thenReturn(orderMock);
        when(mySqlOrderDaoMock.updateOrder(1,"l", 1, "s","1:1","1.1.1","done")).thenReturn(true);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.updateStatus(requestMock,responseMock));
    }

    @Test
    public void shouldReturnUsers() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mySqlOrderDaoMock.getAllOrders4User(1)).thenReturn(new ArrayList<>());
        when(mySqlOrderDaoMock.getAllOrders4Admin()).thenReturn(new ArrayList<>());
        when(mySqlOrderDaoMock.getAllOrders4Master("l")).thenReturn(new ArrayList<>());
        when(mySqlOrderDaoMock.getAllOrders4Payment()).thenReturn(new ArrayList<>());
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(USER_LOGIN)).thenReturn(new ArrayList<>());
        Assertions.assertEquals(ADMIN_HOME_JSP,testingInstance.getAdminOrders(requestMock,responseMock));
        Assertions.assertEquals(MASTER_HOME_JSP,testingInstance.getMasterOrders(requestMock,responseMock));
        Assertions.assertEquals(GET_PAYMENT_JSP,testingInstance.getPaymentOrders(requestMock,responseMock));
    }

}
