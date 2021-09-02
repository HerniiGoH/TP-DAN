package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.exceptions.ConnectionErrorException;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class WebClientServiceImpl implements WebClientService {
    private final WebClient webClient;

    public WebClientServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public <T> T get(Class<T> tipo, String url, Object... args) throws BusinessRuleException {
        T dto;
        try {
            dto = webClient
                    .get()
                    .uri(url, args)
                    .retrieve()
                    .bodyToMono(tipo)
                    .block();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionErrorException();
        }
        return dto;
    }

    @Override
    public <T> T get(Class<T> tipo, String url, Map<String, ?> parameters) throws BusinessRuleException {
        T dto;
        try {
            dto = webClient
                    .get()
                    .uri(url, parameters)
                    .retrieve()
                    .bodyToMono(tipo)
                    .block();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionErrorException();
        }
        return dto;
    }
}
