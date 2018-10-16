package com.devfuns.core.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sim on 2018/8/29.
 * 系统的Configuration类，配置了ObjectMapper的格式化内容
 * MapperScan mybatis的mapper接口扫描范围
 */
@Configuration
@MapperScan(basePackages = "com.devfuns.mapper")
public class BlogConfig {

    @Bean(name = "objectMapper")
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return objectMapper;
    }


}
