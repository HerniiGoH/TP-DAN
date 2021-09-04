package com.tpdan.msproductos.service;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.model.dto.DetallePedido;
import com.tpdan.msproductos.model.dto.Pedido;

import java.util.List;

public interface RabbitService {
    void recibirMensaje(List<DetallePedido> detallePedidoList) throws BusinessRuleException;
}
