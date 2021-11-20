package com.my.controller.service;

import com.my.controller.service.implementation.FeedbackServiceImpl;
import com.my.dao.mysql.MySqlFeedbackDao;
import com.my.entity.Feedback;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.Constants.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class FeedbackServiceImplTest {

    @Mock
    private MySqlFeedbackDao mySqlFeedbackDaoMock;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private HttpSession sessionMock;
    @Mock
    private List<Feedback> feedbacksMock= new ArrayList<>();
    @Mock
    private Feedback feedbackMock;
    @InjectMocks
    private FeedbackServiceImpl testInstance;

    @Test
    public void shouldInitFeedbacks() throws Exception {
        MockitoAnnotations.initMocks(this);
        feedbacksMock.add(feedbackMock);
    when(mySqlFeedbackDaoMock.getAllFeedbacks()).thenReturn(feedbacksMock);
        Assertions.assertEquals(FEEDBACK_JSP,testInstance.feedbackInit(requestMock,responseMock));
    }
    @Test
    public void shouldWriteFeedback() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(USER_ID)).thenReturn(1);
        when(requestMock.getParameter(MESSAGE)).thenReturn("message");
        when(requestMock.getParameter(RATE)).thenReturn("1");
        when(requestMock.getParameter(MASTER)).thenReturn("master");
        when(mySqlFeedbackDaoMock.createFeedback(anyInt(),anyString())).thenReturn(true);
        doReturn(null).doReturn(feedbackMock).when(mySqlFeedbackDaoMock).getFeedback(anyInt(),anyString());
        when(mySqlFeedbackDaoMock.updateFeedback(anyInt(),anyInt(),anyString(),anyString(),anyString())).thenReturn(true);
        Assertions.assertEquals(SUCCESS_JSP,testInstance.feedbackWrite(requestMock,responseMock));
    }
}
