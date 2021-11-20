package com.my.controller.command;

import com.my.controller.service.implementation.AccountCreationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountCreationCommand implements Command {
    AccountCreationServiceImpl accountCreationServiceImplementation= new AccountCreationServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(AccountCreationCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("creating account");
        return accountCreationServiceImplementation.creation(request,response);
    }
}
