package com.my.controller;


import com.my.controller.command.Command;
import com.my.controller.command.CommandContainer;
import com.my.dao.DBManager;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    DBManager instance= DBManager.getInstance();

    public void init() {
        String filePath = this.getClass().getResource("/").getPath();
        filePath = filePath.substring(1).replace("bin", "src");
        PropertyConfigurator.configure(filePath + "log4j2.properties");
        logger.debug("servlet initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("controller DoGet");
        String commandName=request.getParameter("command");
        Command command= CommandContainer.getCommand(commandName);
        String address= "view/error.jsp";
        try{
            address=command.execute(request,response);
        }
        catch (Exception ex){
            logger.warn("command in CommandContainer don't exist");
            request.setAttribute("ex",ex);
        }
        request.getRequestDispatcher(address).forward(request,response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("controller DoPost");
        String commandName=request.getParameter("command");
        Command command= CommandContainer.getCommand(commandName);
        String address= "view/error.jsp";
        try{
        address=command.execute(request,response);
        }
        catch (Exception ex){
            logger.warn("command in CommandContainer don't exist");
            request.getSession().setAttribute("ex",ex);
        }
        response.sendRedirect(address);
    }


    public void destroy(){
        logger.debug("servlet destroyed");
    }
}