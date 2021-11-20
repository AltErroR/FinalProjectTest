package com.my.controller.service;

import com.my.controller.service.implementation.HomePageServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.my.constants.Constants.*;


public class HomePageServiceImplTest {

    @InjectMocks
    private HomePageServiceImpl testingInstance;

    @Test
    public void shouldReturnHomeForUser(){
        MockitoAnnotations.initMocks(this);
        Assertions.assertEquals(MAIN_PAGE_COMMAND,testingInstance.getHome("user"));
    }
    @Test
    public void shouldReturnHomeForMaster(){
        MockitoAnnotations.initMocks(this);
        Assertions.assertEquals(MASTER_HOMEPAGE_COMMAND,testingInstance.getHome("master"));
    }
    @Test
    public void shouldReturnHomeForAdmin(){
        MockitoAnnotations.initMocks(this);
        Assertions.assertEquals(ADMIN_HOMEPAGE_COMMAND,testingInstance.getHome("admin"));
    }

}
