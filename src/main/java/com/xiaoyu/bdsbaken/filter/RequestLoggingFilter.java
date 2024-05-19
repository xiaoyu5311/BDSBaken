package com.xiaoyu.bdsbaken.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
@Slf4j
public class RequestLoggingFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        // 获取请求的路径
        String path = ((HttpServletRequest) request).getRequestURI();

        // 打印请求的路径
        log.info("Request Path: " + path);

        // 继续请求的传递
        chain.doFilter(request, response);
    }

    // 过滤器初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // 这里可以进行一些初始化操作，如果不需要可以不实现该方法
    }

    // 过滤器销毁
    @Override
    public void destroy()
    {
        // 这里可以进行一些清理操作，如果不需要可以不实现该方法
    }
}
