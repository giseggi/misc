package com.giseggi.misc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "naver.open-api")
@ConfigurationPropertiesScan
@Data
public class ApiProperties {

    String clientId;

    String clientSecret;
}
