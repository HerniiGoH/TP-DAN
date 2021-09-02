package com.tpdan.msusuarios.exceptions;

public class ClienteConPedidosException extends BusinessRuleException {
    public ClienteConPedidosException(){
        super("No se puede eliminar clientes que tengan un pedido.");
    }
}
