package com.tpdan.mspagos.service;

import com.tpdan.mspagos.exceptions.BusinessRuleException;

import java.util.Map;

public interface WebClientService {
    public <T> T get(Class<T> tipo, String url, Map<String, Object> parameters, Object... args) throws BusinessRuleException;
}
