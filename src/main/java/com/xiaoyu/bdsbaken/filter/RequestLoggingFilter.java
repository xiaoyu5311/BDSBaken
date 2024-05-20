package com.xiaoyu.bdsbaken.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;


@WebFilter("/*")
@Slf4j
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 将ServletRequest转换为HttpServletRequest
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 获取请求的路径
        String path = httpRequest.getRequestURI();

        // 打印请求的路径
        log.info("Request Path: " + path);

        // 如果是POST请求，读取并打印请求体
        if ("POST".equalsIgnoreCase(httpRequest.getMethod())) {
            HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
            String requestBody = requestWrapper.getBody();
            log.info("Request Body: " + requestBody);

            // 将包装后的请求继续传递
            chain.doFilter(requestWrapper, response);
        } else {
            // 对于非POST请求，继续传递原始请求
            chain.doFilter(request, response);
        }
    }

    // 过滤器初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 这里可以进行一些初始化操作，如果不需要可以不实现该方法
    }

    // 过滤器销毁
    @Override
    public void destroy() {
        // 这里可以进行一些清理操作，如果不需要可以不实现该方法
    }

    // 内部类，用于包装HttpServletRequest以读取请求体
    private static class HttpRequestWrapper extends HttpServletRequestWrapper {

        private final String body;

        public HttpRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            // 读取请求体并将其存储在body变量中
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }
            body = stringBuilder.toString();
        }

        public String getBody() {
            return body;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            // 返回包含请求体的ServletInputStream
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
            return new ServletInputStream() {
                @Override
                public int read() throws IOException {
                    return byteArrayInputStream.read();
                }

                @Override
                public boolean isFinished() {
                    return byteArrayInputStream.available() == 0;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener readListener) {
                    // No-op
                }
            };
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(getInputStream()));
        }
    }
}
