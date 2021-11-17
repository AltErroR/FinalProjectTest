package com.my.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//@WebFilter("/*")
public class UserFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(UserFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        logger.info("user filter started");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        String path = request.getRequestURI();
        String fullpath = path;
        if (session != null) {
            fullpath = path + '?' + request.getQueryString();
        }
        if (fullpath.contains("&")) {
            fullpath = fullpath.substring(0, fullpath.indexOf("&"));
        }
        if ((null != session && null != session.getAttribute("role")) &&
                "user".equals(session.getAttribute("role")) &&
                !"/FPT/view/booking.jsp".equals(path) &&
                !"/FPT/view/success.jsp".equals(path) &&
                !"/FPT/view/error.jsp".equals(path) &&
                !"/FPT/view/footer.jsp".equals(path) &&
                !"/FPT/view/header.jsp".equals(path) &&
                !"/FPT/view/feedback.jsp".equals(path) &&
                !"/FPT/view/main.jsp".equals(path) &&
                !"/FPT/view/writeFeedback.jsp".equals(path) &&

                !"/FPT/controller?command=feedback".equals(fullpath) &&
                !"/FPT/controller?command=feedbackWrite".equals(fullpath) &&
                !"/FPT/controller?command=orders".equals(fullpath) &&
                !"/FPT/controller?command=error".equals(fullpath) &&
                !"/FPT/controller?command=success".equals(fullpath) &&
                !"/FPT/controller?command=mainPage".equals(fullpath) &&
                !"/FPT/controller?command=mainPageByMaster".equals(fullpath) &&
                !"/FPT/controller?command=mainPageByService".equals(fullpath)&&
                !"/FPT/controller?command=booking".equals(fullpath) &&
                !"/FPT/controller?command=login".equals(fullpath) &&
                !"/FPT/controller?command=logout".equals(fullpath)){
            logger.info("user tried to access permitted pages");
            request.getRequestDispatcher("view/main.jsp?command=mainPage").forward(req, resp);
            return;

        }
        logger.info("user access granted");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
