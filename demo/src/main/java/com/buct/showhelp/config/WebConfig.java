package com.buct.showhelp.config;

import com.buct.showhelp.config.intercepors.AdminInterceptor;
import com.buct.showhelp.config.intercepors.LoginInterceptor;
import com.buct.showhelp.pojo.Admin;
import com.buct.showhelp.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/loginMethod", "/user/login", "/user/registerpage", "/user/register", "/index", "/user/sendCode", "/error/awsl", "/user/forgetPasswordPage", "/user/resetPassword", "information/resetPassword", "information/sendCode");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/login", "/admin/loginMethod", "/admin/register",  "/admin/registerMethod");
    }
}
