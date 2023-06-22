package org.yearup.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    BasicDataSource dataSource = new BasicDataSource();



    @Autowired
    public DatabaseConfig(@Value("${datasource.url}")String url,
                          @Value("${datasource.username}") String username,
                          @Value("${datasource.password}")String password) {
        this.dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    @Bean
    public DataSource datasource(){
        return dataSource;
    }
}
