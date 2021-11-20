package com.my.controller.service;

import com.my.controller.service.implementation.AccountCreationServiceImpl;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlMasterDao;
import com.my.dao.mysql.MySqlUserDao;
import com.my.entity.Account;
import com.my.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.constants.Constants.*;
import static com.my.constants.Constants.ROLE;
import static org.mockito.Mockito.*;

public class AccountCreationServiceImplTest {

    @Mock
    private HttpSession sessionMock;
    @Mock
    private MySqlAccountDao mySqlAccountDaoMock;
    @Mock
    private MySqlUserDao mySqlUserDaoMock;
    @Mock
    private MySqlMasterDao mySqlMasterDaoMock;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private Account accountMock;
    @Mock
    private User userMock;
    @InjectMocks
    private AccountCreationServiceImpl testInstance;

    @Test
    public void accountUserCreationTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(PASSWORD_REPEAT)).thenReturn(PASSWORD);
        when(requestMock.getParameter(EMAIL)).thenReturn(EMAIL);
        when(requestMock.getParameter(ROLE)).thenReturn(USER);
        when(mySqlAccountDaoMock.createAccount(anyString())).thenReturn(true);
        doReturn(null).doReturn(accountMock).when(mySqlAccountDaoMock).getAccount(anyString());
        when(mySqlAccountDaoMock.updateAccount(anyInt(),anyString(),anyString(),anyString())).thenReturn(true);
        when(mySqlUserDaoMock.createUser(anyInt())).thenReturn(true);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(mySqlUserDaoMock.getUser(anyInt())).thenReturn(userMock);
        Assertions.assertEquals(MAIN_JSP,testInstance.creation(requestMock,responseMock));
    }

    @Test
    public void accountMasterCreationTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(PASSWORD_REPEAT)).thenReturn(PASSWORD);
        when(requestMock.getParameter(EMAIL)).thenReturn(EMAIL);
        when(requestMock.getParameter(ROLE)).thenReturn(MASTER);
        when(mySqlAccountDaoMock.createAccount(anyString())).thenReturn(true);
        doReturn(null).doReturn(accountMock).when(mySqlAccountDaoMock).getAccount(anyString());
        when(mySqlAccountDaoMock.updateAccount(anyInt(),anyString(),anyString(),anyString())).thenReturn(true);
        when(mySqlMasterDaoMock.createMaster(anyString())).thenReturn(true);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(mySqlUserDaoMock.getUser(anyInt())).thenReturn(userMock);
        Assertions.assertEquals(MASTER_HOME_JSP,testInstance.creation(requestMock,responseMock));
    }

}
