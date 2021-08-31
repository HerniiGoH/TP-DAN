package com.tpdan.mspedidos.validator;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public interface PedidoValidator {
    void validarCreacion(Pedido pedido) throws BusinessRuleException;
    void validarCreacionDetalle(DetallePedido detallePedido, Integer id) throws BusinessRuleException;
    void validarActualizarPedido(Pedido pedido) throws BusinessRuleException;
    void validarActualizarDetallePedido(DetallePedido detallePedido, Integer id) throws BusinessRuleException;
    void validarBorrarPedido(Integer id) throws BusinessRuleException;
    void validarBorrarDetallePedido(Integer idPedido, Integer id) throws BusinessRuleException;
    void validarConfirmacion(Integer id) throws BusinessRuleException;
}
