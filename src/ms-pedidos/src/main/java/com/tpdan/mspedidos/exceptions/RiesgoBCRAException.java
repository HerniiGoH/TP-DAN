package com.tpdan.mspedidos.exceptions;

public class RiesgoBCRAException extends BusinessRuleException{
    public RiesgoBCRAException(){
        super("El Riesgo BCRA del solicitante no le permite continuar la transacción.");
    }
}
