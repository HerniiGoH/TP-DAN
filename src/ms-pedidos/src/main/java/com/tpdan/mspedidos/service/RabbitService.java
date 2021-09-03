package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;

public interface RabbitService {
    void enviarMensaje(Object mensaje) throws BusinessRuleException;
}
