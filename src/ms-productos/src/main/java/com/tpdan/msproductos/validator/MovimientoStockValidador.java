package com.tpdan.msproductos.validator;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.model.Producto;
import com.tpdan.msproductos.model.dto.DetallePedido;
import com.tpdan.msproductos.model.dto.Pedido;

import java.util.List;

public interface MovimientoStockValidador {
    List<Producto> validarCreacion(List<DetallePedido> detallePedidoList) throws BusinessRuleException;
}
