package com.my.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
      logger.info("login filter started");
       HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session =request.getSession(false);
        String path = request.getRequestURI();
        String fullpath = path;
        if (session != null) {
            fullpath = path + '?' + request.getQueryString();
        }
        if (fullpath.contains("&")) {
            fullpath = fullpath.substring(0, fullpath.indexOf("&"));
        }
        if ((null == session || null == session.getAttribute("role")) &&
                (!"/FPT/view/accountCreation.jsp".equals(path) &&
                        !"/FPT/view/authorization.jsp".equals(path) &&
                        !"/FPT/view/success.jsp".equals(path) &&
                        !"/FPT/view/error.jsp".equals(path) &&
                        !"/FPT/view/header.jsp".equals(path) &&
                        !"/FPT/view/footer.jsp".equals(path) &&
                        !"/FPT/view/main.jsp".equals(path) &&
                        !"/FPT/index.jsp".equals(path) &&
                        !"/FPT/".equals(path) &&

                        !"/FPT/controller?command=creation".equals(fullpath) &&
                        !"/FPT/controller?command=login".equals(fullpath) &&
                        !"/FPT/controller?command=error".equals(fullpath) &&
                        !"/FPT/controller?command=success".equals(fullpath) &&
                        !"/FPT/controller?command=mainPage".equals(fullpath) &&
                        !"/FPT/controller?command=mainPageByMaster".equals(fullpath) &&
                        !"/FPT/controller?command=mainPageByService".equals(fullpath) &&
                        !"/FPT/controller?command=mainPageByRating".equals(fullpath) &&
                        !"/FPT/controller?command=mainPageByMasterLogin".equals(fullpath) &&
                        !"/FPT/controller?command=mainPageByServiceName".equals(fullpath)
                )) {
            logger.info("unauthorized user tried to access permitted pages");
            request.getRequestDispatcher("/view/authorization.jsp").forward(req, resp);
            return;
        }
        logger.info("access granted");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
