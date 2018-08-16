package com.devperson.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.IDAutoGen;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.UUID;

@Configuration
public class DataSourceConfig {


    @Autowired
    SqlManagerFactoryBean sqlManagerFactoryBean;


    @Bean(name = "dataSource")
    public DataSource dataSource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }

    @Bean(name = "SQLManager")
    public SQLManager sqlManager() {
        try {
            SQLManager sqlManager = sqlManagerFactoryBean.getObject();
            sqlManager.addIdAutonGen("guid", new IDAutoGen() {
                @Override
                public Object nextID(String params) {
                    return UUID.randomUUID();
                }
            });
            return sqlManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Bean
//    public BeetlSqlDataSource beetlSqlDataSource(@Qualifier("dataSource") DataSource dataSource){
//        BeetlSqlDataSource source = new BeetlSqlDataSource();
//        source.setMasterSource(dataSource);
//        return source;
//    }


}
