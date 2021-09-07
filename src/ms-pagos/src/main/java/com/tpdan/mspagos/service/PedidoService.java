package com.tpdan.mspagos.service;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.dto.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido buscarPedidoPorId(Integer id) throws BusinessRuleException;
    List<Pedido> buscarPedidosPorId(List<Integer>ids) throws BusinessRuleException;
}
