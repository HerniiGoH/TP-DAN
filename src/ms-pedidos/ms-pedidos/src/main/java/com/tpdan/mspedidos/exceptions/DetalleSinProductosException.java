package com.tpdan.mspedidos.exceptions;

public class DetalleSinProductosException extends BusinessRuleException{
    public DetalleSinProductosException(){
        super("Todos los productos del detalle deben tener Nombre y Precio.");
    }
}
