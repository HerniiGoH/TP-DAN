package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;

import java.util.Map;

public interface WebClientService {
    <T> T get(Class<T> tipo , String url, Object ...args) throws BusinessRuleException;

    <T> T get(Class<T> tipo , String url, Map<String, ?> parameters) throws BusinessRuleException;
}
