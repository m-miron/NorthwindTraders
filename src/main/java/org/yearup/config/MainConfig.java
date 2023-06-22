package org.yearup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yearup.dao.ProductDao;
import org.yearup.dao.SimpleProductDao;

@Configuration
public class MainConfig {

    @Bean
    ProductDao productDao(){
        return new SimpleProductDao();
    }
}
