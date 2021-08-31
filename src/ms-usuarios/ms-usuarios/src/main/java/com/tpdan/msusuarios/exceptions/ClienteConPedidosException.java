package com.tpdan.msusuarios.exceptions;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;

public class ClienteConPedidosException extends BusinessRuleException {
    public ClienteConPedidosException(){
        super("No se puede eliminar clientes que tengan un pedido.");
    }
}
