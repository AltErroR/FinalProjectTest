package com.my.controller.service.imlementation;

import com.my.controller.Controller;
import com.my.controller.service.MainPageService;
import com.my.dao.mysql.MySqlMasterServiceDao;
import com.my.entity.MasterService;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MainPageServiceImpl implements MainPageService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    MySqlMasterServiceDao mySqlMasterServiceDao= new MySqlMasterServiceDao();
    List<MasterService> masterServiceList = new ArrayList<>();
    int noOfRecords=mySqlMasterServiceDao.getAmmount();
    int page = 1;
    int recordsPerPage = 4;

    @Override
    public String mainPageInitialization(String query,HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        HttpSession session= request.getSession(false);

        if(noOfRecords==0){
            logger.warn("no data in master_service table");
            return "view/error.jsp";
        }
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int noOfPages = (int) Math.ceil(noOfRecords / recordsPerPage);


        if(query.equals(SQL_SUBLIST_BY_MASTER_NAME)&&request.getParameter("masterName")!=null){
            masterServiceList = mySqlMasterServiceDao.getAllMasterServicesByName(query,request.getParameter("masterName"),(page-1)*recordsPerPage, recordsPerPage);
        }
        else if(query.equals(SQL_SUBLIST_BY_SERVICE_NAME)&&request.getParameter("serviceName")!=null){
            masterServiceList = mySqlMasterServiceDao.getAllMasterServicesByName(query,request.getParameter("serviceName"),(page-1)*recordsPerPage, recordsPerPage);
        }
        else {
            masterServiceList = mySqlMasterServiceDao.getAllMasterServices(query, (page - 1) * recordsPerPage, recordsPerPage);
        }
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("masterServiceList", masterServiceList);

        if (query.equals(SQL_SUBLIST_BY_MASTER)) {
            logger.info("list sorted by master");
            request.setAttribute("sortBy", "master");
            return "view/main.jsp?command=mainPageByMaster";
        }
        if (query.equals(SQL_SUBLIST_BY_SERVICE)) {
            logger.info("list sorted by service");
            request.setAttribute("sortBy", "service");
            return "view/main.jsp?command=mainPageByService";
        }
        if (query.equals(SQL_SUBLIST_BY_RATING)) {
            logger.info("list sorted by rating");
            request.setAttribute("sortBy", "rating");
            return "view/main.jsp?command=mainPageByRating";
        }
        if (query.equals(SQL_SUBLIST_BY_MASTER_NAME)) {
            logger.info("list sorted by master login");
            request.setAttribute("sortBy", "masterName");
            return "view/main.jsp?command=mainPageByMasterLogin";
        }
        if (query.equals(SQL_SUBLIST_BY_SERVICE_NAME)) {
            logger.info("list sorted by service name");
            request.setAttribute("sortBy", "serviceName");
            return "view/main.jsp?command=mainPageByServiceName";
        }
        request.setAttribute("sortBy", "id");
        logger.info("list sorted by id");
        return "view/main.jsp?command=mainPage";
    }
}
