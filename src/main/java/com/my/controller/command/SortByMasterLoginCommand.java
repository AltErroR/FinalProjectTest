package com.my.controller.command;

import com.my.controller.service.imlementation.MainPageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.SQLConstants.SQL_SUBLIST_BY_MASTER_NAME;

public class SortByMasterLoginCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SortByMasterLoginCommand.class);
    MainPageServiceImpl mainPageServiceImplementation= new MainPageServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //todo
        logger.debug("try to sort data on main by master login");
        return mainPageServiceImplementation.mainPageInitialization(SQL_SUBLIST_BY_MASTER_NAME,response,request);
    }
}
