package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.exceptions.ConnectionErrorException;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.Map;

@Service
public class WebClientServiceImpl implements WebClientService {
    private final WebClient webClient;

    public WebClientServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public <T> T get(Class<T> tipo, String url, Map<String, Object> parameters) throws BusinessRuleException {
        T dto;
        try {
            dto = webClient
                    .get()
                    .uri(url, uriBuilder->uriBuilder
                            .queryParams(convertirMap(parameters))
                            .build())
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
