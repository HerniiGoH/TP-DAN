package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;

public interface WebClientService {
    public <T> T get(Class<T> tipo, String url, Object... args) throws BusinessRuleException;
}
