package com.tpdan.mspedidos.exceptions;

public class PedidoSinObraException extends BusinessRuleException{
    public PedidoSinObraException(){
        super("El pedido debe de estar asociado a una obra.");
    }
}
