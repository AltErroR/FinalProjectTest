package com.my.controller;


import com.my.controller.command.Command;
import com.my.controller.command.CommandContainer;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static com.my.constants.Constants.*;


@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @Override
    public void init() {
        String filePath = this.getClass().getResource("/").getPath();
        filePath = filePath.substring(1).replace(BIN, SRC);
        PropertyConfigurator.configure(filePath + LOG4J_PROPERTIES);
        logger.debug("servlet initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("controller DoGet");
        String commandName=request.getParameter("command");
        Command command= CommandContainer.getCommand(commandName);
        String address= ERROR_JSP;
        try{
            address=command.execute(request,response);
        }
        catch (Exception ex){
            logger.warn("command in CommandContainer don't exist");
            request.setAttribute("ex",ex);
        }
        request.getRequestDispatcher(address).forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("controller DoPost");
        String commandName=request.getParameter("command");
        Command command= CommandContainer.getCommand(commandName);
        String address= ERROR_JSP;
        try{
        address=command.execute(request,response);
        }
        catch (Exception ex){
            logger.warn("command in CommandContainer don't exist");
            request.getSession().setAttribute("ex",ex);
        }
        response.sendRedirect(address);
    }


    @Override
    public void destroy(){
        logger.debug("servlet destroyed");
    }
}