package com.my.controller.service;

import com.my.controller.service.implementation.MainPageServiceImpl;
import com.my.dao.mysql.MySqlMasterServiceDao;
import com.my.entity.MasterService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.my.constants.Constants.MAIN_JSP;
import static com.my.constants.Constants.PAGE;
import static com.my.constants.SQLConstants.*;
import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainPageServiceImplTest {
    @Mock
    private MySqlMasterServiceDao mySqlMasterServiceDaoMock ;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private HttpSession sessionMock;
    @Mock
    private  String queryMock;
    @Mock
    private final List<MasterService> masterServiceListMock= new ArrayList<>();
    @InjectMocks
    MainPageServiceImpl testingInstance = new com.my.controller.service.implementation.MainPageServiceImpl();


    @Test
    public void shouldReturnMainPage() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        when(mySqlMasterServiceDaoMock.getAmount()).thenReturn(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getParameter(PAGE)).thenReturn("9");
        when(mySqlMasterServiceDaoMock.getAllMasterServices(queryMock, 0, 4)).thenReturn(masterServiceListMock);
        when(queryMock.equals(SQL_SUBLIST_BY_SERVICE)).thenReturn(true);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(queryMock,responseMock,requestMock));
    }
}
