package com.my.controller.service.imlementation;

import com.my.controller.command.HomePageCommand;
import com.my.controller.service.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageServiceImpl implements HomePageService {
    private static final Logger logger = LoggerFactory.getLogger(HomePageServiceImpl.class);
    @Override
    public String getHome(String role) {
        switch (role) {
            case ("master"):
                logger.debug("master homepage");
                return "/FPT/controller?command=masterHomeInit";
            case ("admin"):
                logger.debug("admin homepage");
                return "/FPT/controller?command=adminHomeInit";
            default:
                logger.debug("user homepage");
                return "/FPT/controller?command=mainPage";
        }
    }
}
