package com.my.controller.service.implementation;

import com.my.controller.service.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.my.constants.Constants.*;

public class HomePageServiceImpl implements HomePageService {
    private static final Logger logger = LoggerFactory.getLogger(HomePageServiceImpl.class);
    @Override
    public String getHome(String role) {
        switch (role) {
            case ("master"):
                logger.debug("master homepage");
                return MASTER_HOMEPAGE_COMMAND;
            case ("admin"):
                logger.debug("admin homepage");
                return ADMIN_HOMEPAGE_COMMAND;
            default:
                logger.debug("user homepage");
                return MAIN_PAGE_COMMAND;
        }
    }
}
