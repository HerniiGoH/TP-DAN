package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.dto.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> buscarPedidosPorCliente(Integer id, String cuit) throws BusinessRuleException;
}
