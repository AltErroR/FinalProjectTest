package com.my.controller.service;

import com.my.controller.service.implementation.LoginServiceImpl;
import com.my.controller.service.implementation.OrderProcessingServiceImpl;
import com.my.dao.mysql.*;
import com.my.entity.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.my.constants.Constants.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServiceImplTest {

    @Mock
    private MySqlAccountDao mySqlAccountDaoMock;
    @Mock
    private MySqlAdminDao mySqlAdminDaoMock;
    @Mock
    private MySqlMasterDao mySqlMasterDaoMock;
    @Mock
    private MySqlUserDao mySqlUserDaoMock;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private User userMock;
    @Mock
    private Master masterMock;
    @Mock
    private Admin adminMock;
    @Mock
    private Account accountMock;
    @Mock
    private HttpSession sessionMock;

    @InjectMocks
    private LoginServiceImpl testingInstance;

    @Test
    public void shouldLoginUser() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(accountMock.getPassword()).thenReturn(PASSWORD);
        when(mySqlUserDaoMock.getUser(accountMock.getId())).thenReturn(userMock);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(ROLE)).thenReturn(USER);
        when(mySqlAccountDaoMock.getAccount(LOGIN)).thenReturn(accountMock);
        Assertions.assertEquals(MAIN_PAGE_COMMAND,testingInstance.login(requestMock,responseMock));
    }
    @Test
    public void shouldLoginMaster() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(accountMock.getPassword()).thenReturn(PASSWORD);
        when(mySqlMasterDaoMock.getMaster(accountMock.getLogin())).thenReturn(masterMock);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(ROLE)).thenReturn(MASTER);
        when(mySqlAccountDaoMock.getAccount(LOGIN)).thenReturn(accountMock);
        Assertions.assertEquals(MASTER_HOMEPAGE_COMMAND,testingInstance.login(requestMock,responseMock));
    }
    @Test
    public void shouldLoginAdmin() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(accountMock.getPassword()).thenReturn(PASSWORD);
        when(mySqlAdminDaoMock.getAdmin(accountMock.getId())).thenReturn(adminMock);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(ROLE)).thenReturn(USER);
        when(mySqlAccountDaoMock.getAccount(LOGIN)).thenReturn(accountMock);
        Assertions.assertEquals(ADMIN_HOMEPAGE_COMMAND,testingInstance.login(requestMock,responseMock));
    }
}
