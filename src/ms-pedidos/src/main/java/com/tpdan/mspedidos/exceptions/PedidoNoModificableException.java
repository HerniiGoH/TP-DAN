package com.tpdan.mspedidos.exceptions;

public class PedidoNoModificableException extends BusinessRuleException{
    public PedidoNoModificableException(){
        super("Solo los pedidos en estado NUEVO pueden ser modificados.");
    }
}
