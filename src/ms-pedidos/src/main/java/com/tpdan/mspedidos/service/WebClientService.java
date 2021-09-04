package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Map;

public interface WebClientService {
    <T> T get(Class<T> tipo , String url, Map<String, Object> parameters) throws BusinessRuleException;
}
