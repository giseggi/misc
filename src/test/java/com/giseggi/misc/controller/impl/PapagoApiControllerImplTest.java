package com.giseggi.misc.controller.impl;

import com.giseggi.misc.controller.PapagoApiController;
import com.giseggi.misc.service.PapagoApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PapagoApiControllerImplTest {

    @Autowired
    private PapagoApiController papapgoApiController;

    @MockBean
    private PapagoApiService papagoApiService;

    @Nested
    class detectLang {

        public static Collection<Arguments>parameter () {
            return Arrays.asList(
                    Arguments.of("hello", "en"),
                    Arguments.of("안녕하세요", "ko"),
                    Arguments.of("こんにちは", "ja"),
                    Arguments.of("Guten Tag", "de")
            );
        }

        @ParameterizedTest
        @MethodSource("parameter") // 1: text, 2: langCode
        @DisplayName("정상")
        void normal(String text, String langCode) throws JSONException {
            // given
            // Mock
            doReturn(langCode).when(papagoApiService).detectLang(text);

            // when
            String result = papapgoApiController.detectLang(text);

            assertEquals(new StringBuilder("detected lang is ").append(langCode).append("! :)").toString(), result);

        }
    }

}