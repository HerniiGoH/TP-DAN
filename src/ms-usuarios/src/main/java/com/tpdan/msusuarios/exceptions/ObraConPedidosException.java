package com.tpdan.msusuarios.exceptions;

public class ObraConPedidosException extends BusinessRuleException{
    public ObraConPedidosException(){
        super("No se puede borrar una obra que cuente con pedidos previos.");
    }
}
