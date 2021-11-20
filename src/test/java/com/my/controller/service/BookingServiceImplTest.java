package com.my.controller.service;

import com.my.controller.service.implementation.BookingServiceImpl;
import com.my.dao.mysql.MySqlOrderDao;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.my.constants.Constants.SUCCESS_JSP;
import static org.mockito.Mockito.*;

public class BookingServiceImplTest {
    @Mock
    private MySqlOrderDao mySqlOrderDaoMock;
    @InjectMocks
    private BookingServiceImpl testInstance;

    @Test
    public void bookingTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mySqlOrderDaoMock.getOrder(anyString(),anyString(),anyString(),anyString())).thenReturn(null);
        when(mySqlOrderDaoMock.createOrder(anyString(),anyInt(),anyString(),anyString(),anyString())).thenReturn(true);
        Assertions.assertEquals(SUCCESS_JSP,testInstance.booking("anyString()","anyString()","anyString()","anyString()",1));
    }
}
