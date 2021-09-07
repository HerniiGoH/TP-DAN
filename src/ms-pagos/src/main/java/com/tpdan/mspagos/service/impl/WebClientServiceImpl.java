package com.tpdan.mspagos.service.impl;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.exceptions.ConnectionErrorException;
import com.tpdan.mspagos.service.WebClientService;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.Map;

@Component
public class WebClientServiceImpl implements WebClientService {
    private final WebClient webClient;

    public WebClientServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public <T> T get(Class<T> tipo, String url, Map<String, Object> parameters, Object... args) throws BusinessRuleException {
        T dto;
        try {
            dto = webClient
                    .get()
                    .uri(uriBuilder->uriBuilder
                            .path(url)
                            .queryParams(convertirMap(parameters))
                            .build(args))
                    .retrieve()
                    .bodyToMono(tipo)
                    .block();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionErrorException();
        }
        return dto;
    }

    private LinkedMultiValueMap<String, String> convertirMap(Map<String, Object> map){
        LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<>();
        map.forEach((clave, valor)->{
            if(valor!=null){
                linkedMultiValueMap.put(clave, Collections.singletonList(valor.toString()));
            }
        });
        return linkedMultiValueMap;
    }
}
