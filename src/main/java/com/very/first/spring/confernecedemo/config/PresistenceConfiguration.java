package com.very.first.spring.confernecedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PresistenceConfiguration {
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://${MYSQL_HOST:localhost}:3306/testspring");
        System.out.println("Connect to datasource");
        return builder.build();
    }
}
