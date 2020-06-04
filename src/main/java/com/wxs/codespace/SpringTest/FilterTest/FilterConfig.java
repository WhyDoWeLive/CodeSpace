package com.wxs.codespace.SpringTest.FilterTest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 以前的Web项目是在Web.xml中完成的
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/filter");
        //通过@WebFilter方式注册Filter不能指定优先级，通常@WebFilter注册的Filter按照类名的倒序排序，并且都高于通过FilterRegistrationBean注册的Filter
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
