package com.my.controller.command;

import com.my.controller.service.imlementation.MainPageServiceImpl;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.SQLConstants.SQL_SUBLIST_BY_SERVICE;

public class SortByServiceCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(SortByServiceCommand.class);
    MainPageServiceImpl mainPageServiceImplementation= new MainPageServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to sort data on main by service ");
        return mainPageServiceImplementation.mainPageInitialization(SQL_SUBLIST_BY_SERVICE,response,request);
    }
}
