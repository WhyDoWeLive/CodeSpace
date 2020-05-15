package com.wxs.codespace.SpringTest.FilterTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 注册过滤器方式一：@WebFilter（有一些可选属性）这样创建一个filter时，启动类上要加@ServletComponentScan；
 * 并且声明filter的优先级会不方便。
 *
 * 注册过滤器方式二：通过配置类和FilterRegistrationBean，相见文件FilterConfig。此时可先将注册方式一的动作注释掉
 */
@WebFilter(urlPatterns = "/*")
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Myfilter is coming~");
        //如果doFilter()之后不想想继续执行程序则不调用下面的方法即可
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
