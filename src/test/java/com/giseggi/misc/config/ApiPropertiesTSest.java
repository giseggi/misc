package com.giseggi.misc.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiPropertiesTSest {

    @Value("${naver.open-api.client-id}")
    private String id;

    @Value("${naver.open-api.client-secret}")
    private String secret;

    @Autowired
    private ApiProperties apiProperties;

    @Test
    void test() {

        assertEquals(apiProperties.getClientId(), id);
        assertEquals(apiProperties.getClientSecret(), secret);

    }

}