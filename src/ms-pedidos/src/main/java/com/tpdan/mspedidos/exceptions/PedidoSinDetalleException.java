package com.tpdan.mspedidos.exceptions;

public class PedidoSinDetalleException extends BusinessRuleException{
    public PedidoSinDetalleException(){
        super("El pedido debe tener al menos un detalle de pedido asociado.");
    }
}
