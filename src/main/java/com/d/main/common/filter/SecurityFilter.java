package com.d.main.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
public class SecurityFilter implements Filter {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("SecurityFilter.init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.info("SecurityFilter.destroy");
    }
}
