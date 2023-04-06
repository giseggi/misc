package com.giseggi.misc.controller.impl;

import com.giseggi.misc.controller.PapagoApiController;
import com.giseggi.misc.service.PapagoApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/papagoApi")
@RequiredArgsConstructor
public class PapagoApiControllerImpl implements PapagoApiController {

    private final PapagoApiService papagoApiService;

    @Override
    @PostMapping("/detectLang")
    public String detectLang(@RequestParam(value = "text", required = false, defaultValue = "hello") String text) {
        try {
            String lang = papagoApiService.detectLang(text);
            return String.format("detected lang is %s! :)", lang);
        } catch (Exception e) {
            return "error occurred :(";
        }
    }
}
