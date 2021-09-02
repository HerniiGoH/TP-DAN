package com.tpdan.mspedidos.exceptions;

public class PedidoInexistenteException extends BusinessRuleException{
    public PedidoInexistenteException(){
        super("El pedido solicitado no existe.");
    }
}
