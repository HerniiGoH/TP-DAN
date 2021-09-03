package com.tpdan.msproductos.service;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.model.dto.Pedido;

public interface RabbitService {
    void recibirMensaje(Pedido pedido) throws BusinessRuleException;
}
