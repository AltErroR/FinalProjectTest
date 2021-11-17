package com.my.controller.command;

import javax.servlet.http.*;


public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
