package com.devfuns.core.config;

import com.devfuns.core.interceptor.AdminControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Component
public class BlogWebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    AdminControllerInterceptor adminControllerInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(adminControllerInterceptor).addPathPatterns("/admin/*");
    }
}
