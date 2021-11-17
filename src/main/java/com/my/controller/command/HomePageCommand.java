package com.my.controller.command;

import com.my.controller.service.imlementation.HomePageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(HomePageCommand.class);
    HomePageServiceImpl homePageService = new HomePageServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to redirect to homepage");
        String role=request.getSession().getAttribute("role").toString();
        return homePageService.getHome(role);
    }
}
