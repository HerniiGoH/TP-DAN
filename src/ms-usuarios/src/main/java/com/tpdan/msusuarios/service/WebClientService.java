package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;

import java.util.Map;

public interface WebClientService {
    public <T> T get(Class<T> tipo, String url, Map<String, Object> map) throws BusinessRuleException;
}
