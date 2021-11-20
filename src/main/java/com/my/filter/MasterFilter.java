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
public class MasterFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MasterFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //notodo
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        logger.info("master filter started");
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
                MASTER.equals(session.getAttribute(ROLE)) &&
                !SUCCESS_JSP_PATH.equals(path) &&
                !ERROR_JSP_PATH.equals(path) &&
                !MASTER_HOME_JSP_PATH.equals(path) &&
                !FEEDBACK_JSP_PATH.equals(path) &&
                !FOOTER_JSP_PATH.equals(path) &&
                !HEADER_JSP_PATH.equals(path) &&
                !MAIN_JSP_PATH.equals(path) &&

                !FEEDBACK_COMMAND.equals(fullpath) &&
                !MASTER_HOME_COMMAND.equals(fullpath) &&
                !MAIN_PAGE_COMMAND.equals(fullpath) &&
                !SORT1_COMMAND.equals(fullpath) &&
                !SORT2_COMMAND.equals(fullpath) &&
                !SORT3_COMMAND.equals(fullpath) &&
                !SORT4_COMMAND.equals(fullpath) &&
                !SORT5_COMMAND.equals(fullpath) &&
                !STATUS_CHANGE_COMMAND.equals(fullpath) &&
                !LOGIN_COMMAND.equals(fullpath) &&
                !LOG_OUT_COMMAND_PATH.equals(fullpath)&&
                !CHANGE_LANGUAGE_COMMAND.equals(fullpath)
        ) {
            logger.info("master tried to access permitted pages");
            request.getRequestDispatcher("/view/masterHome.jsp").forward(req, resp);
            return;
        }
        logger.info("master access granted");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        //notodo
    }
}