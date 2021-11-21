package com.my.controller.service.implementation;

import com.my.controller.service.MainPageService;
import com.my.dao.DaoFactory;
import com.my.dao.MasterServiceDao;
import com.my.dao.OrderDao;
import com.my.dao.mysql.MySqlDaoFactory;
import com.my.dao.mysql.MySqlMasterServiceDao;
import com.my.entity.MasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.Constants.*;
import static com.my.constants.SQLConstants.*;

public class MainPageServiceImpl implements MainPageService {
    private static final Logger logger = LoggerFactory.getLogger(MainPageServiceImpl.class);
    DaoFactory daoFactory= new MySqlDaoFactory();
    MasterServiceDao mySqlMasterServiceDao= daoFactory.getMasterServiceDao();
    List<MasterService> searchList = new ArrayList<>();
    int noOfRecords=mySqlMasterServiceDao.getAmount();
    int page = 1;
    int recordsPerPage = 4;

    @Override
    public String mainPageInitialization(String query,HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        HttpSession session= request.getSession();
        if(noOfRecords==0){
            logger.warn("no data in master_service table");
            return ERROR_JSP;
        }
        if(request.getParameter(PAGE) != null)
            page = Integer.parseInt(request.getParameter(PAGE));
        int noOfPages = (noOfRecords / recordsPerPage);

        if(query.equals(SQL_SUBLIST_BY_MASTER_NAME)&&request.getParameter(MASTER)!=null){
            searchList = mySqlMasterServiceDao.getAllMasterServicesByName(query,request.getParameter(MASTER),(page-1)*recordsPerPage, recordsPerPage);
        }
        else if(query.equals(SQL_SUBLIST_BY_SERVICE_NAME)&&request.getParameter(SERVICE)!=null){
            searchList = mySqlMasterServiceDao.getAllMasterServicesByName(query,request.getParameter(SERVICE),(page-1)*recordsPerPage, recordsPerPage);
        }
        else {
            searchList = mySqlMasterServiceDao.getAllMasterServices(query, (page - 1) * recordsPerPage, recordsPerPage);
        }
        request.setAttribute(NUMBER_OF_PAGES, noOfPages);
        request.setAttribute(CURRENT_PAGE, page);
        session.setAttribute(SEARCH_LIST, searchList);

        if (query.equals(SQL_SUBLIST_BY_MASTER)) {
            logger.info("list sorted by master");
            request.setAttribute(SORT_BY, MASTER);
        }
        if (query.equals(SQL_SUBLIST_BY_SERVICE)) {
            logger.info("list sorted by service");
            request.setAttribute(SORT_BY, SERVICE);
        }
        if (query.equals(SQL_SUBLIST_BY_RATING)) {
            logger.info("list sorted by rating");
            request.setAttribute(SORT_BY, RATING);
        }
        if (query.equals(SQL_SUBLIST_BY_MASTER_NAME)) {
            logger.info("list sorted by master login");
            request.setAttribute(SORT_BY, MASTER_NAME);
        }
        if (query.equals(SQL_SUBLIST_BY_SERVICE_NAME)) {
            logger.info("list sorted by service name");
            request.setAttribute(SORT_BY, SERVICE_NAME);
        }
        if (query.equals(SQL_SUBLIST_BY_ID)) {
            request.setAttribute(SORT_BY, ID);
            logger.info("list sorted by id");
        }
        return MAIN_JSP;
    }
}
