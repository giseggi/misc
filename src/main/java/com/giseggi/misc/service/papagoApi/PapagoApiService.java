package com.giseggi.misc.service.papagoApi;

import org.springframework.boot.configurationprocessor.json.JSONException;

public interface PapagoApiService {

    public String detectLang(String text) throws JSONException;

}
