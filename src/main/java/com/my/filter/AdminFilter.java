package com.my.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.my.constants.Constants.*;

@WebFilter("/*")
public class AdminFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(AdminFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //notodo
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        logger.info("admin filter started");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        String path = request.getRequestURI();
        String fullpath = path;
        if (session != null) {
            fullpath = path + '?' + request.getQueryString();
        }
        if (fullpath.contains("language=uk")||fullpath.contains("language=en")) {
            fullpath =  path + '?' +"command=changeLanguage";
        }
        if (fullpath.contains("&")) {
            fullpath = fullpath.substring(0, fullpath.indexOf("&"));
        }
        if ((null != session && null != session.getAttribute(ROLE)) &&
                ADMIN.equals(session.getAttribute(ROLE)) &&
                !SUCCESS_JSP_PATH.equals(path) &&
                !ERROR_JSP_PATH.equals(path) &&
                !ADMIN_HOME_JSP_PATH.equals(path) &&
                !FEEDBACK_JSP_PATH.equals(path) &&
                !FOOTER_JSP_PATH.equals(path) &&
                !HEADER_JSP_PATH.equals(path) &&
                !MAIN_JSP_PATH.equals(path) &&

                !LOG_OUT_COMMAND_PATH.equals(fullpath) &&
                !LOGIN_COMMAND.equals(fullpath) &&
                !ERROR_COMMAND.equals(fullpath) &&
                !SUCCESS_COMMAND.equals(fullpath) &&
                !ADMIN_HOME_COMMAND.equals(fullpath) &&
                !ORDER_CHANGE_COMMAND.equals(fullpath) &&
                !MAIN_PAGE_COMMAND.equals(fullpath) &&
                !SORT1_COMMAND.equals(fullpath) &&
                !SORT2_COMMAND.equals(fullpath) &&
                !SORT3_COMMAND.equals(fullpath) &&
                !SORT4_COMMAND.equals(fullpath) &&
                !SORT5_COMMAND.equals(fullpath) &&
                !ACCEPT_PAYMENT_COMMAND.equals(fullpath) &&
                !PAYMENT_COMMAND.equals(fullpath) &&
                !FEEDBACK_COMMAND.equals(fullpath)&&
                !CHANGE_LANGUAGE_COMMAND.equals(fullpath)
        ){
            logger.info("admin tried to access permitted pages");
            request.getRequestDispatcher(ADMIN_HOME_JSP).forward(req, resp);
            return;
        }
        logger.info("admin access granted");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        //notodo
    }
}

