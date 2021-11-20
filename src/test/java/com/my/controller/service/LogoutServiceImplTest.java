package com.my.controller.service;

import com.my.controller.service.implementation.LogoutServiceImpl;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlServiceDao;
import com.my.entity.Service;
import com.my.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.constants.Constants.LOG_OUT_COMMAND;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class LogoutServiceImplTest {

    @InjectMocks
    private LogoutServiceImpl testInstance;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private HttpSession sessionMock;

    @Test
    public void shouldLogOut() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    when(requestMock.getSession()).thenReturn(sessionMock);
        Assertions.assertEquals(LOG_OUT_COMMAND,testInstance.exit(requestMock,responseMock));
    }

}
