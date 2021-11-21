package com.my.controller.command;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.constants.Constants.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ChangeLanguageCommandTest {
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private HttpSession sessionMock;
    @InjectMocks
    private ChangeLanguageCommand testInstance;

    @Test
    public void shouldReturnOnMain() throws Exception {
        MockitoAnnotations.initMocks(this);
       when(requestMock.getSession()).thenReturn(sessionMock);
       when(requestMock.getParameter(LANGUAGE)).thenReturn("language");
       when(requestMock.getHeader(anyString())).thenReturn(" ?language ");
        Assertions.assertEquals(LOG_OUT_COMMAND,testInstance.execute(requestMock,responseMock));
    }
    @Test
    public void shouldChangeLanguage() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getParameter(LANGUAGE)).thenReturn("language");
        when(requestMock.getHeader(anyString())).thenReturn(MAIN_PAGE_COMMAND);
        Assertions.assertNotEquals("",testInstance.execute(requestMock,responseMock));
    }
}
