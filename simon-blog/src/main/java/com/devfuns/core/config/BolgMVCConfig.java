package com.devfuns.core.config;

import com.devfuns.core.converter.StringToDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by sim on 2018/8/29.
 * MVC的转换器配置
 */
@Configuration
@EnableAspectJAutoProxy
public class BolgMVCConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addConverter(new StringToDateConverter());
    }
}
