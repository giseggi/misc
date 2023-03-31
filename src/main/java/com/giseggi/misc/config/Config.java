package com.giseggi.misc.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApiProperties.class)
public class Config {

    @Bean
    public ApiProperties apiProperties() {
        return new ApiProperties();
    }

}
