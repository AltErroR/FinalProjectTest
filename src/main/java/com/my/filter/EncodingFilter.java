package com.my.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static com.my.constants.Constants.UTF_8;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(EncodingFilter.class);


    @Override
    public void init(FilterConfig config) throws ServletException {
        //notodo
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(UTF_8);
        response.setCharacterEncoding(UTF_8);
        logger.info("request and response encoding set to UTF-8");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        // notodo
    }
}
